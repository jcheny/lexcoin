package com.lexcoin.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:chenyu
 * @Date: 2019/11/6 11:42
 */
@Data
public class UserReq implements Serializable {

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    private String account;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty("验证码")
    private String verificationCode;


}
