package com.lexcoin.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_money")
public class TbUserMoney {
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取币种
     *
     * @return coin_id - 币种
     */
    public String getCoinId() {
        return coinId;
    }

    /**
     * 设置币种
     *
     * @param coinId 币种
     */
    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取可用余额
     *
     * @return available_amount - 可用余额
     */
    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    /**
     * 设置可用余额
     *
     * @param availableAmount 可用余额
     */
    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    /**
     * 获取冻结余额
     *
     * @return frozen_amount - 冻结余额
     */
    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * 设置冻结余额
     *
     * @param frozenAmount 冻结余额
     */
    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * 获取锁仓余额
     *
     * @return lock_amount - 锁仓余额
     */
    public BigDecimal getLockAmount() {
        return lockAmount;
    }

    /**
     * 设置锁仓余额
     *
     * @param lockAmount 锁仓余额
     */
    public void setLockAmount(BigDecimal lockAmount) {
        this.lockAmount = lockAmount;
    }

    /**
     * 获取其他余额
     *
     * @return other_amount - 其他余额
     */
    public BigDecimal getOtherAmount() {
        return otherAmount;
    }

    /**
     * 设置其他余额
     *
     * @param otherAmount 其他余额
     */
    public void setOtherAmount(BigDecimal otherAmount) {
        this.otherAmount = otherAmount;
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取乐观锁
     *
     * @return version_lock - 乐观锁
     */
    public Long getVersionLock() {
        return versionLock;
    }

    /**
     * 设置乐观锁
     *
     * @param versionLock 乐观锁
     */
    public void setVersionLock(Long versionLock) {
        this.versionLock = versionLock;
    }
}