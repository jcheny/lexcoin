package com.lexcoin.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_coin")
@Data
public class TbCoin {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 币种名称
     */
    @Column(name = "coin_name")
    private String coinName;

    /**
     * 币种代码
     */
    @Column(name = "coin_code")
    private String coinCode;

    /**
     * 币种状态
     */
    private Integer status;

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
     * 获取币种名称
     *
     * @return coin_name - 币种名称
     */
    public String getCoinName() {
        return coinName;
    }

    /**
     * 设置币种名称
     *
     * @param coinName 币种名称
     */
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    /**
     * 获取币种代码
     *
     * @return coin_code - 币种代码
     */
    public String getCoinCode() {
        return coinCode;
    }

    /**
     * 设置币种代码
     *
     * @param coinCode 币种代码
     */
    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    /**
     * 获取币种状态
     *
     * @return status - 币种状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置币种状态
     *
     * @param status 币种状态
     */
    public void setStatus(Integer status) {
        this.status = status;
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