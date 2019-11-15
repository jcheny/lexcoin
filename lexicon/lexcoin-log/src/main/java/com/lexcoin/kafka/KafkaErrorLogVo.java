package com.lexcoin.kafka;

import lombok.Data;

/**
 * kafka全局异常消息实体对象
 * @Author:chenyu
 * @Date: 2019/9/16 16:41
 */
@Data
public class KafkaErrorLogVo {

    private String mobile;

    private String address;

    private String errorMsg;
}
