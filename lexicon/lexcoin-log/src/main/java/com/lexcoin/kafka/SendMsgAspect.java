package com.lexcoin.kafka;


import com.lexcoin.vo.ApiResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * kafka 注解切面
 * <p>
 * 1、入参要不继承SendMsgObj，要不自定义topic，如果两者都有则以继承为主
 * 2、消息date来源方法的返回值中，主要结构体，此处没有对所有的结构兼容，只处理ApiResult（本项目中）
 * 3、采取的消息加密与解密为默认，请选择seed为null 即可
 */
@Aspect
@Component
public class SendMsgAspect {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Pointcut("@annotation(com.lexcoin.kafka.SendMsg)")
    public void annotationPointCut() {
    }

    @AfterReturning(pointcut = "annotationPointCut() && @annotation(sendMsg)", returning = "rvt")
    public void before(JoinPoint joinPoint, Object rvt, SendMsg sendMsg) throws Exception {
        if (joinPoint.getArgs().length == 0) {
            throw new SendMsgException();
        }
        List<Object> objects = Arrays.asList(joinPoint.getArgs());

        //接受结果
        ApiResult result = (ApiResult) rvt;
        String resultData = (String) result.getData();
        if (StringUtils.isEmpty(resultData)) {
            return;
        }
        //解密结果
        String date = AES.decrypt(null, resultData);

        for (Object obj : objects) {
            if (obj instanceof SendMsgObj) {
                //比对toptic
                String code = ((SendMsgObj) obj).getCode();
                String toptic = SendMsgEnums.getValue(code);
                if (StringUtils.isEmpty(toptic)) {
                    throw new SendMsgException();
                }
                kafkaTemplate.send(toptic, date);
                return;
            }
        }
        //没有匹配
        kafkaTemplate.send(sendMsg.topics(), date);

    }

}
