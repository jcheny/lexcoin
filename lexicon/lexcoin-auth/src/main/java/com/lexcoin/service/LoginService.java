package com.lexcoin.service;

import com.lexcoin.vo.request.UserReq;

public interface LoginService {
    String doLogin(UserReq userReq);
}
