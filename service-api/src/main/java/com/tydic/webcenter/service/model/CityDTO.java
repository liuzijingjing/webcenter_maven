package com.tydic.webcenter.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/20 15:57
 */
@Getter
@Setter
@ToString(callSuper = true)
public class CityDTO extends BaseDTO {

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String state;
}
