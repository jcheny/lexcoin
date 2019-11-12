package com.lexcoin.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_money")
@Data
public class TbUserMoney {

    public TbUserMoney(){
        this.availableAmount = BigDecimal.ZERO;
        this.frozenAmount = BigDecimal.ZERO;
        this.lockAmount = BigDecimal.ZERO;
        this.otherAmount = BigDecimal.ZERO;
    }


    public void flush(TbUserMoney tbUserMoney){
        tbUserMoney.setAvailableAmount(null);
        tbUserMoney.setFrozenAmount(null);
        tbUserMoney.setLockAmount(null);
        tbUserMoney.setOtherAmount(null);
    }

    /**
     * 主键
     */
    @Id
    @ApiModelProperty("主键")
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 币种
     */
    @Column(name = "coin_id")
    @ApiModelProperty("币种")
    private String coinId;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 可用余额
     */
    @Column(name = "available_amount")
    @ApiModelProperty("可用余额")
    private BigDecimal availableAmount;

    /**
     * 冻结余额
     */
    @Column(name = "frozen_amount")
    @ApiModelProperty("冻结余额")
    private BigDecimal frozenAmount;

    /**
     * 锁仓余额
     */
    @Column(name = "lock_amount")
    @ApiModelProperty("锁仓余额")
    private BigDecimal lockAmount;

    /**
     * 其他余额
     */
    @Column(name = "other_amount")
    @ApiModelProperty("其他余额")
    private BigDecimal otherAmount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 乐观锁
     */
    @Column(name = "version_lock")
    @ApiModelProperty("乐观锁")
    private Long versionLock;


}