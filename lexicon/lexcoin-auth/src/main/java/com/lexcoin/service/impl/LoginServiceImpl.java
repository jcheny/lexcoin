package com.lexcoin.service.impl;

import com.lexcoin.mapper.TbUserMapper;
import com.lexcoin.pojo.TbUser;
import com.lexcoin.service.LoginService;
import com.lexcoin.utils.JwtUtil;
import com.lexcoin.vo.request.UserReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author:chenyu
 * @Date: 2019/11/6 11:41
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    public String doLogin(UserReq userReq) {
        TbUser tbUser = new TbUser();
        tbUser.setAccount(userReq.getAccount());
        tbUser.setPassword(userReq.getPassword());
        TbUser tbUserX = tbUserMapper.selectOne(tbUser);
        if(Objects.isNull(tbUserX)){
            return null;
        }
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", tbUserX.getId());
        claims.put("account", tbUserX.getAccount());
        claims.put("description", tbUserX.getDescription());
        claims.put("name", tbUserX.getName());
        String property = applicationContext.getEnvironment().getProperty("jwt.jwtExpiration");
        if(StringUtils.isBlank(property)){
            return null;
        }
        long aLong = Long.parseLong(property);
        String jwt = null;
        try {
            jwt = JwtUtil.createJWT(tbUserX.getId(), claims, tbUserX.getId(), aLong);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return jwt;
    }
}
