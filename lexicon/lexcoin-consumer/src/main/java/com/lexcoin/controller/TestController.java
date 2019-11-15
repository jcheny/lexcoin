package com.lexcoin.controller;

import com.lexcoin.service.KafkaService;
import com.lexcoin.service.TestService;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import com.lexcoin.vo.KafkaVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 11:07
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private TestService testService;

    @Resource
    private KafkaService kafkaService;



    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Value("${spring.application.name}")
    private String appName;

    @PostMapping(value = "/echo/app/name")
    public String echo1() {
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("lexcoin-provider");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping(value = "/echo/hi")
    public String echo2() {
        return testService.echo("Hi Feign:"+applicationContext.getEnvironment().getProperty("user.test"));
    }

    @PostMapping(value = "/echo/jwt")
    public ApiResult echo3() {
        return ResultGenerator.genSuccessData("ok");
    }

    @PostMapping(value = "/echo/kafka")
    public ApiResult echo4(@RequestBody KafkaVo kafkaVo) {
        kafkaService.sendMsg(kafkaVo);
        return ResultGenerator.genSuccessData("ok");
    }



}
