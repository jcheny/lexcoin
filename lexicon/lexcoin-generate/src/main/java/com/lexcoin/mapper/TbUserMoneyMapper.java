package com.lexcoin.mapper;

import com.lexcoin.invariable.MyMapper;
import com.lexcoin.pojo.TbUserMoney;

import java.util.ArrayList;

public interface TbUserMoneyMapper extends MyMapper<TbUserMoney> {
    int insertLists(ArrayList<TbUserMoney> tbUserMonies);
}