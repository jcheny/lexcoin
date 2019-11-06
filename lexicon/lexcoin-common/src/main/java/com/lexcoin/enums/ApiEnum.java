package com.lexcoin.enums;

import lombok.Getter;

@Getter
public enum ApiEnum {

    UNAUTHORIZED(401,"未授权"),
    INSUFFICIENT_PERMISSIONS(4001,"访问资源的用户权限不足"),
    ACCESS_TOKEN_INVALID(4002,"Token无效"),
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    ApiEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;
}
