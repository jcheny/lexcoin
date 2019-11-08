package com.lexcoin.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
@Data
public class TbUser implements Serializable {
    @Id
    private String id;

    private String account;

    private String description;

    private String password;

    private String name;

    @Column(name = "version_lock")
    @Version
    private Integer versionLock;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return version_lock
     */
    public Integer getVersionLock() {
        return versionLock;
    }

    /**
     * @param versionLock
     */
    public void setVersionLock(Integer versionLock) {
        this.versionLock = versionLock;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}