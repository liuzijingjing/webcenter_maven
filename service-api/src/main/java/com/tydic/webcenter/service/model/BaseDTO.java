package com.tydic.webcenter.service.model;

import lombok.Data;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/20 15:36
 */
@Data
public class BaseDTO implements Serializable {

    @NotNull
    @NotBlank
    @NotEmpty
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer page = 1;

    @NotNull
    @NotBlank
    @NotEmpty
    private Integer rows = 10;

//    /**
//     * 创建时间
//     */
//    @NotNull
//    @NotBlank
//    @NotEmpty
//    private Date createdAt;
//
//    /**
//     * 创建人
//     */
//    @NotNull
//    @NotBlank
//    @NotEmpty
//    private String createdBy;
//
//    /**
//     * 更新时间
//     */
//    @NotNull
//    @NotBlank
//    @NotEmpty
//    private Date updatedAt;
//
//    /**
//     * 最后更新人
//     */
//    @NotNull
//    @NotBlank
//    @NotEmpty
//    private String updatedBy;
}
