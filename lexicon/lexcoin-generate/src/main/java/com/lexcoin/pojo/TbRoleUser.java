package com.lexcoin.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_role_user")
@Data
public class TbRoleUser implements Serializable {
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_id")
    private Integer userId;

    @Version
    @Column(name = "version_lock")
    private Integer versionLock;

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
}