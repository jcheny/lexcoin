package com.lexcoin.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_flowing_water")
@Data
public class TbFlowingWater {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 从钱包
     */
    @Column(name = "from_wallet")
    private String fromWallet;

    /**
     * 到钱包
     */
    @Column(name = "to_wallet")
    private String toWallet;

    /**
     * 从用户
     */
    @Column(name = "from_user")
    private String fromUser;

    /**
     * 到用户
     */
    @Column(name = "to_user")
    private String toUser;

    /**
     * 币种id
     */
    @Column(name = "coin_id")
    private String coinId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 描述
     */
    private String describes;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

}