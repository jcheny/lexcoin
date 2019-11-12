package com.lexcoin.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_configuration")
@Data
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
    private String describes;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}