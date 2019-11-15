package com.lexcoin.exception;

import com.lexcoin.enums.ApiEnum;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:chenyu
 * @Date: 2019/11/14 11:35
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResult exceptionHandler(HttpServletRequest request, Exception e) {
        //绑定异常是需要明确提示给用户的
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
            return ResultGenerator.genResult(exception.getApiEnum());
        }
         //其余异常简单返回为服务器异常
        return ResultGenerator.genResult(ApiEnum.FAIL);

    }

}
