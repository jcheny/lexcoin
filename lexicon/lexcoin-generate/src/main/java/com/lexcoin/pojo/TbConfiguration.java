package com.lexcoin.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_configuration")
public class TbConfiguration {
    @Id
    private String id;

    /**
     * 键值
     */
    private String key;

    /**
     * value值
     */
    private String value;

    /**
     * 描述
     */
    private String describe;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取键值
     *
     * @return key - 键值
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置键值
     *
     * @param key 键值
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取value值
     *
     * @return value - value值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value值
     *
     * @param value value值
     */
    public void setValue(String value) {
        this.value = value;
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