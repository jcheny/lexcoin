package com.lexcoin.controller;

import com.lexcoin.vo.KafkaVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:chenyu
 * @Date: 2019/11/14 15:12
 */
@RestController
@Slf4j
public class MsgController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody KafkaVo kafkaVo) {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(kafkaVo.getTopic(), kafkaVo.getData());
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("msg send failed.", throwable);
            }
            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("msg OK. " + stringStringSendResult.toString());
            }
        });
    }

}
