package com.lexcoin.mapper;

import com.lexcoin.invariable.MyMapper;
import com.lexcoin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {

    User selectParam(User user);

}