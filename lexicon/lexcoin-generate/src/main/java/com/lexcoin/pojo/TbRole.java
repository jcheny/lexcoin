package com.lexcoin.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_role")
@Data
public class TbRole implements Serializable {
    @Id
    private Integer id;

    private String description;

    @Column(name = "created_time")
    private Long createdTime;

    private String name;

    private String role;

    @Column(name = "version_lock")
    @Version
    private Integer versionLock;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return created_time
     */
    public Long getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
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
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
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