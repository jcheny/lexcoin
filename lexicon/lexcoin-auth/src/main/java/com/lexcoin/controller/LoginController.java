package com.lexcoin.controller;

import com.lexcoin.service.LoginService;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import com.lexcoin.vo.request.UserReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户验证接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/auth/login")
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
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
