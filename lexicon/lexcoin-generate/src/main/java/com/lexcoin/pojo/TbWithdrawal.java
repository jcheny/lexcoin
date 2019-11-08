package com.lexcoin.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_withdrawal")
public class TbWithdrawal {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 币种
     */
    @Column(name = "coin_id")
    private String coinId;

    /**
     * 提现地址
     */
    private String address;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 提现状态0：未提现，1：已提现，2：提现失败
     */
    private Integer status;

    /**
     * 乐观锁
     */
    @Column(name = "version_lock")
    private Long versionLock;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取提现地址
     *
     * @return address - 提现地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置提现地址
     *
     * @param address 提现地址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取失败原因
     *
     * @return reason - 失败原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置失败原因
     *
     * @param reason 失败原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取提现状态0：未提现，1：已提现，2：提现失败
     *
     * @return status - 提现状态0：未提现，1：已提现，2：提现失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置提现状态0：未提现，1：已提现，2：提现失败
     *
     * @param status 提现状态0：未提现，1：已提现，2：提现失败
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}