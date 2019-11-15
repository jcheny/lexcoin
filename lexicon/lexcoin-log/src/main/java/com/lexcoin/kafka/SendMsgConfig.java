package com.lexcoin.kafka;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 消息枚举配置类
 */
@Component
public class SendMsgConfig implements SendMsgTopicFactory {


    @Override
    public void addEnum(String enumName, String code, String name) {
        tobeEnum(enumName, code, name);
    }

    public void setSendMsgConfig(String enumName, String code, String name) {
        addEnum(enumName, code, name);
    }

    public void setSendMsgConfig(Set<SendMsgObj> set) {
        for (SendMsgObj next : set) {
            addEnum(next.getEnumName(), next.getCode(), next.getName());
        }
    }

    public void setSendMsgConfig(List<Map<String, Map<String, String>>> enums) {
        String enumName = null;
        String code = null;
        String name = null;
        for (Map<String, Map<String, String>> mapMap : enums) {
            for (Map.Entry<String, Map<String, String>> heat : mapMap.entrySet()) {
                if (mapMap.entrySet().size() > 1) {
                    throw new SendMsgException();
                }
                enumName = heat.getKey();
                Map<String, String> value = heat.getValue();
                for (Map.Entry<String, String> body : value.entrySet()) {

                    if (value.entrySet().size() > 1) {
                        throw new SendMsgException();
                    }
                    code = body.getKey();
                    name = body.getValue();
                }
            }
            addEnum(enumName, code, name);
        }
    }

}
