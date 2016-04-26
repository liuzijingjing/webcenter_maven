package com.tydic.webcenter.persistence.model;

import lombok.*;

import javax.persistence.Table;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/15 14:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name = "user_info")
public class UserDO extends BaseDO {

    private String username;
    private String password;
    private String usertype;
    private Integer enabled;
    private String qq;
    private String email;
    private String tel;

}