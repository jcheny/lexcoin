package com.lexcoin.mapper;

import com.lexcoin.invariable.MyMapper;
import com.lexcoin.pojo.TbUser;
import com.lexcoin.vo.UserVo;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper extends MyMapper<TbUser> {

    UserVo findUserByAccount(@Param("username") String username);

}