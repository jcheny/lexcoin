package com.lexcoin.exception;

import com.lexcoin.enums.ApiEnum;
import com.lexcoin.vo.ApiResult;
import lombok.Data;

/**
 * @Author:chenyu
 * @Date: 2019/11/14 11:55
 */
@Data
public class GlobalException extends RuntimeException {

    private ApiEnum apiEnum;
    public GlobalException(ApiEnum apiEnum) {
        super(apiEnum.toString());
        this.apiEnum = apiEnum;
    }

}
