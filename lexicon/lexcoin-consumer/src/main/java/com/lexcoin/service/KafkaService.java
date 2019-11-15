package com.lexcoin.service;

import com.lexcoin.fallback.KafkaFallback;
import com.lexcoin.fallback.RegisterFallback;
import com.lexcoin.pojo.TbUser;
import com.lexcoin.vo.KafkaVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "lexcoin-log", fallback = KafkaFallback.class)
public interface KafkaService {

    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody KafkaVo kafkaVo);

}
