package com.tydic.webcenter.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/20 15:41
 */
@Data
public class BaseDO implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

//    /**
//     * 创建时间
//     */
//    @Column(name = "created_at")
//    private Date createdAt;
//
//    /**
//     * 创建人
//     */
//    @Column(name = "created_by")
//    private String createdBy;
//
//    /**
//     * 更新时间
//     */
//    @Column(name = "updated_at")
//    private Date updatedAt;
//
//    /**
//     * 最后更新人
//     */
//    @Column(name = "updated_by")
//    private String updatedBy;
}