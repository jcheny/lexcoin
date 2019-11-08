package com.lexcoin.controller;

import com.lexcoin.pojo.TbUser;
import com.lexcoin.service.RegisterService;
import com.lexcoin.utils.Md5Utils;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenyu
 * @Date: 2019/11/8 16:59
 */
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Boolean register(@RequestBody TbUser tbUser){
        tbUser.setPassword(Md5Utils.md5(tbUser.getPassword()));
        return registerService.register(tbUser);
    }

}
