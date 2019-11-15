package com.lexcoin.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * 消息枚举注入配置类
 */
@Configuration
public class ConfigMsg {

    @Value("${kafka.producer.topics}")
    private String topic;

    @Bean
    public SendMsgConfig setEnums() {
        Set<SendMsgObj> sendMsgObjs = new HashSet<>();
        List<String> strings = Arrays.asList(topic.trim().split("/"));
        for(String str : strings){
            String[] split = str.trim().split(",");
            SendMsgObj sendMsgObj = new SendMsgObj();
            sendMsgObj.setEnumName(UUID.randomUUID().toString().replaceAll("-","_"));
            sendMsgObj.setCode(split[0]);
            sendMsgObj.setName(split[1]);
            sendMsgObjs.add(sendMsgObj);
        }
        SendMsgConfig sendMsgConfig = new SendMsgConfig();
        sendMsgConfig.setSendMsgConfig(sendMsgObjs);
        return sendMsgConfig;
    }

}
