package com.lexcoin.service;

import com.lexcoin.fallback.RegisterFallback;
import com.lexcoin.pojo.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "lexcoin-provider", fallback = RegisterFallback.class)
public interface RegisterService {

    @PostMapping("/register")
    public Boolean register(@RequestBody TbUser tbUser);

}
