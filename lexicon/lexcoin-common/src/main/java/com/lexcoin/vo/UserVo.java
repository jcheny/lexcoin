package com.lexcoin.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 21:35
 */
@Data
public class UserVo implements Serializable {

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户角色
     */
    private String role;
}
