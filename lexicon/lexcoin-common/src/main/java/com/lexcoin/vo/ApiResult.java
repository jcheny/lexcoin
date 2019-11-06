package com.lexcoin.vo;

import com.alibaba.fastjson.JSON;
import com.lexcoin.enums.ApiEnum;
import lombok.Data;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 21:01
 */
@Data
public class ApiResult<T> {
    private int code;
    private String message;
    private T data;

    public ApiResult(ApiEnum tipEnum) {
        this.code = tipEnum.getCode();
        this.message = tipEnum.getMessage();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
