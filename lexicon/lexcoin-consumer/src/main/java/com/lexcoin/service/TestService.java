package com.lexcoin.service;

import com.lexcoin.fallback.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "lexcoin-provider",fallback = TestServiceFallback.class)
public interface TestService {

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message);


}
