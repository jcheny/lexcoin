package com.lexcoin.controller;

import com.lexcoin.pojo.TbUser;
import com.lexcoin.service.RegisterService;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import com.lexcoin.vo.request.UserReq;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:chenyu
 * @Date: 2019/11/8 17:46
 */
@RestController
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping("/register")
    public ApiResult register(@RequestBody UserReq userReq) {
        //todo 校验验证码
        String verificationCode = userReq.getVerificationCode();
        TbUser tbUser = new TbUser();
        BeanUtils.copyProperties(userReq,tbUser);
        Boolean register = registerService.register(tbUser);
        if(register){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult();
    }

}
