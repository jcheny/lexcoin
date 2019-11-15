package com.lexcoin.kafka;

/**
 * 消息枚举类
 */
public enum SendMsgEnums {
    ;
    private String num;

    private String topic;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    SendMsgEnums(String num, String topic) {
        this.num = num;
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public static String getValue(String code) {
        for (SendMsgEnums ele : values()) {
            if (ele.getNum().equals(code)) return ele.getTopic();
        }
        return null;
    }

}
