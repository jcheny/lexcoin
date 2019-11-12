package com.lexcoin.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
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
    private String describes;

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


}