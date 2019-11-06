package com.lexcoin.utils;

import com.lexcoin.enums.ApiEnum;
import com.lexcoin.vo.ApiResult;

/**
 * @Author:chenyu
 * @Date: 2019/11/5 21:08
 */
public class ResultGenerator {

    public static ApiResult genResult(ApiEnum apiEnum) {
        return new ApiResult(apiEnum);
    }

    public static ApiResult genSuccessResult() {
        return new ApiResult(ApiEnum.SUCCESS);
    }

    public static ApiResult genSuccessData(Object object) {
        ApiResult apiResult = new ApiResult<>(ApiEnum.SUCCESS);
        apiResult.setData(object);
        return apiResult;
    }

    public static ApiResult genFailResult() {
        return new ApiResult(ApiEnum.FAIL);
    }

}
