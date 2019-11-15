package com.lexcoin.kafka;

/**
 * 消息枚举生成工厂
 */
public interface SendMsgTopicFactory {

    void addEnum(String enumName, String code, String name);

    default void tobeEnum(String enumName, String code, String name) {
        DynamicEnumUtil.addEnum(SendMsgEnums.class, enumName, new Class<?>[]
                        {String.class, String.class},
                new Object[]{code, name});

    }

}
