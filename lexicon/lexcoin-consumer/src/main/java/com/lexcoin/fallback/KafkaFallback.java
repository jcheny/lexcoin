package com.lexcoin.fallback;

import com.lexcoin.service.KafkaService;
import com.lexcoin.service.TestService;
import com.lexcoin.vo.KafkaVo;
import org.springframework.stereotype.Component;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 14:02
 */
@Component
public class KafkaFallback implements KafkaService {

    @Override
    public void sendMsg(KafkaVo kafkaVo) {

    }
}
