package com.lexcoin.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lexcoin.enums.ApiEnum;
import com.lexcoin.utils.JwtUtil;
import com.lexcoin.vo.ApiResult;
import io.jsonwebtoken.ExpiredJwtException;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:chenyu
 * @Date: 2019/11/6 10:56
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    private ObjectMapper objectMapper;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public AuthFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String method = serverHttpRequest.getMethodValue();
        if ("POST".equals(method)) {
            //从请求里获取Post请求体
            String bodyStr = resolveBodyFromRequest(serverHttpRequest);
            //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
            URI uri = serverHttpRequest.getURI();
            ServerHttpRequest request = serverHttpRequest.mutate().uri(uri).build();
            DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
            request = new ServerHttpRequestDecorator(request) {
                @Override
                public Flux<DataBuffer> getBody() {
                    return bodyFlux;
                }
            };
            //TODO 得到Post请求的请求参数后，做你想做的事
            String url = serverHttpRequest.getURI().getPath();
            String skipAuthUrls = applicationContext.getEnvironment().getProperty("jwt.skipAuthUrls");
            if (StringUtils.isNotBlank(skipAuthUrls)) {
                String[] split = skipAuthUrls.split(",");
                //跳过不需要验证的路径
                if (Arrays.asList(split).contains(url)) {
                    return chain.filter(exchange.mutate().request(request).build());
                }
            }


            //获取token
            String token = exchange.getRequest().getHeaders().getFirst("Authorization");
            ServerHttpResponse resp = exchange.getResponse();
            if (StringUtils.isBlank(token)) {
                //没有token
                return authErro(resp, "请登陆");
            } else {
                //有token
                try {
                    boolean res = JwtUtil.checkToken(token, objectMapper);
                    if(res){
                        //封装request，传给下一级
                        return chain.filter(exchange.mutate().request(request).build());
                    }else {
                        return authErro(resp, "认证失败");
                    }
                } catch (ExpiredJwtException e) {
                    log.error(e.getMessage(), e);
                    if (e.getMessage().contains("Allowed clock skew")) {
                        return authErro(resp, "认证过期");
                    } else {
                        return authErro(resp, "认证失败");
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    return authErro(resp, "认证失败");
                }
            }

            //封装request，传给下一级
        }else {
            return chain.filter(exchange);
        }

    }


    /**
     * 认证错误输出
     *
     * @param resp 响应对象
     * @param mess 错误信息
     * @return
     */
    private Mono<Void> authErro(ServerHttpResponse resp, String mess) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        ApiResult<String> apiResult = new ApiResult<>(ApiEnum.UNAUTHORIZED);
        String returnStr = "";
        try {
            returnStr = objectMapper.writeValueAsString(apiResult);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

    /**
     * 从Flux<DataBuffer>中获取字符串的方法
     * @return 请求体
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();

        AtomicReference<String> bodyRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyRef.set(charBuffer.toString());
        });
        //获取request body
        return bodyRef.get();
    }

    private DataBuffer stringBuffer(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }

    /**
     * 防止Only one connection receive subscriber allowed.
     * @return
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
                return chain.filter(exchange);
            }
        };
    }



    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
