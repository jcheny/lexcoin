package com.lexcoin.fallback;

import com.lexcoin.pojo.User;
import com.lexcoin.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 14:02
 */
@Component
public class TestServiceFallback implements TestService {
    @Override
    public String echo(String message) {
        return "echo fallback";
    }

    @Override
    public User getUser() {
        return new User();
    }
}
