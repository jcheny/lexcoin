package com.lexcoin.fallback;

import com.lexcoin.pojo.TbUser;
import com.lexcoin.service.RegisterService;
import com.lexcoin.utils.ResultGenerator;
import com.lexcoin.vo.ApiResult;
import org.springframework.stereotype.Component;

/**
 * @Author:chenyu
 * @Date: 2019/11/8 17:48
 */
@Component
public class RegisterFallback implements RegisterService {
    @Override
    public Boolean register(TbUser tbUser) {
        return false;
    }
}
