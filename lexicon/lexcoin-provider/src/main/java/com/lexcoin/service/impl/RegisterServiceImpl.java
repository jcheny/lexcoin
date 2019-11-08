package com.lexcoin.service.impl;

import com.google.common.collect.Lists;
import com.lexcoin.mapper.TbCoinMapper;
import com.lexcoin.mapper.TbUserMapper;
import com.lexcoin.mapper.TbUserMoneyMapper;
import com.lexcoin.mapper.TbWalletMapper;
import com.lexcoin.pojo.TbCoin;
import com.lexcoin.pojo.TbUser;
import com.lexcoin.pojo.TbUserMoney;
import com.lexcoin.pojo.TbWallet;
import com.lexcoin.service.RegisterService;
import com.lexcoin.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author:chenyu
 * @Date: 2019/11/8 16:58
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Resource
    private TbUserMoneyMapper tbUserMoneyMapper;

    @Resource
    private TbWalletMapper tbWalletMapper;

    @Resource
    private TbCoinMapper tbCoinMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(TbUser tbUser) {
        tbUser.setId(UuidUtils.getUUID());
        tbUser.setCreateTime(new Date());
        tbUser.setUpdateTime(new Date());
        int a = tbUserMapper.insert(tbUser);
        ArrayList<TbUserMoney> tbUserMonies = Lists.newArrayList();
        List<TbCoin> tbCoins = tbCoinMapper.selectAll();

        TbWallet tbWallet = new TbWallet();
        tbWallet.setId(UuidUtils.getUUID());
        tbWallet.setUserId(tbUser.getId());
        tbWallet.setAddress(UuidUtils.getUUID());
        tbWallet.setDescribe("新用户注册生成");
        tbWallet.setName("默认地址");
        tbWallet.setCreateTime(new Date());
        tbWallet.setUpdateTime(new Date());
        int b = tbWalletMapper.insert(tbWallet);

        for (TbCoin tbCoin : tbCoins) {
            TbUserMoney tbUserMoney = new TbUserMoney();
            tbUserMoney.setId(UuidUtils.getUUID());
            tbUserMoney.setAddress(tbWallet.getId());
            tbUserMoney.setUserId(tbUser.getId());
            tbUserMoney.setCoinId(tbCoin.getId());
            tbUserMoney.setCreateTime(new Date());
            tbUserMoney.setUpdateTime(new Date());
            tbUserMonies.add(tbUserMoney);
        }
        int c = tbUserMoneyMapper.insertList(tbUserMonies);
        return a + b + c == 1 + tbCoins.size() + 1;

    }
}
