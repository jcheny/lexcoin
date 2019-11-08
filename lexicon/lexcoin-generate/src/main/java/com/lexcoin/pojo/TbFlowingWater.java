package com.lexcoin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_flowing_water")
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
    private String describe;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取从钱包
     *
     * @return from_wallet - 从钱包
     */
    public String getFromWallet() {
        return fromWallet;
    }

    /**
     * 设置从钱包
     *
     * @param fromWallet 从钱包
     */
    public void setFromWallet(String fromWallet) {
        this.fromWallet = fromWallet;
    }

    /**
     * 获取到钱包
     *
     * @return to_wallet - 到钱包
     */
    public String getToWallet() {
        return toWallet;
    }

    /**
     * 设置到钱包
     *
     * @param toWallet 到钱包
     */
    public void setToWallet(String toWallet) {
        this.toWallet = toWallet;
    }

    /**
     * 获取从用户
     *
     * @return from_user - 从用户
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * 设置从用户
     *
     * @param fromUser 从用户
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * 获取到用户
     *
     * @return to_user - 到用户
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * 设置到用户
     *
     * @param toUser 到用户
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * 获取币种id
     *
     * @return coin_id - 币种id
     */
    public String getCoinId() {
        return coinId;
    }

    /**
     * 设置币种id
     *
     * @param coinId 币种id
     */
    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    /**
     * 获取金额
     *
     * @return amount - 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置金额
     *
     * @param amount 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取描述
     *
     * @return describe - 描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置描述
     *
     * @param describe 描述
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}