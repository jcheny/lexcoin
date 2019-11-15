package com.lexcoin.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:chenyu
 * @Date: 2019/11/14 15:15
 */
@Data
public class KafkaVo implements Serializable {

    private String topic;

    private String data;
}
