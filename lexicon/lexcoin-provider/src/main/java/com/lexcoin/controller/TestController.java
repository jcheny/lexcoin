package com.lexcoin.controller;

import com.lexcoin.mapper.UserMapper;
import com.lexcoin.pojo.User;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 11:02
 */
@RestController
public class TestController {

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable String message) {
        return "Hello Nacos Discovery " + message;
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/user")
    public User getUser() {
        return userMapper.selectParam(new User());
    }

    @PostMapping(value = "/checkUser")
    public User checkUser(User user) {
        List<User> users = userMapper.select(user);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

}
