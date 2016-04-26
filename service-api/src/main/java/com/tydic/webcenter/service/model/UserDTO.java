package com.tydic.webcenter.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/20 15:57
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserDTO extends BaseDTO {

    private String username;
    private String password;
    private String usertype;
    private Integer enabled;
    private String qq;
    private String email;
    private String tel;
}
