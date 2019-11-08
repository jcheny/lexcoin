package com.lexcoin.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_wallet")
public class TbWallet {
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
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 1:验证，0：没有验证
     */
    @Column(name = "is_verification")
    private Integer isVerification;

    /**
     * 描述
     */
    private String describe;

    /**
     * 是否删除0：没有删除，1：已删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

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
     * 乐观锁
     */
    @Column(name = "version_lock")
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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取1:验证，0：没有验证
     *
     * @return is_verification - 1:验证，0：没有验证
     */
    public Integer getIsVerification() {
        return isVerification;
    }

    /**
     * 设置1:验证，0：没有验证
     *
     * @param isVerification 1:验证，0：没有验证
     */
    public void setIsVerification(Integer isVerification) {
        this.isVerification = isVerification;
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
     * 获取是否删除0：没有删除，1：已删除
     *
     * @return is_delete - 是否删除0：没有删除，1：已删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除0：没有删除，1：已删除
     *
     * @param isDelete 是否删除0：没有删除，1：已删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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