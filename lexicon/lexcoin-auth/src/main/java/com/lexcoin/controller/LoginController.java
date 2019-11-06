package com.lexcoin.controller;

import com.lexcoin.service.LoginService;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import com.lexcoin.vo.request.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenyu
 * @Date: 2019/11/6 11:40
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/auth/login")
    public ApiResult login(@RequestBody UserReq userReq){
        String auth = loginService.doLogin(userReq);
        if(StringUtils.isBlank(auth)){
            return ResultGenerator.genFailResult();
        }
        return ResultGenerator.genSuccessData(auth);
    }

    @PostMapping("/auth/hello")
    public ApiResult hello(){
        return ResultGenerator.genSuccessData("ok");
    }
}
