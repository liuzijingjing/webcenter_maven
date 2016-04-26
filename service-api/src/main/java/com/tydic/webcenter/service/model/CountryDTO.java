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
public class CountryDTO extends BaseDTO {
    /**
     * 名称
     */
    private String countryname;

    /**
     * 代码
     */
    private String countrycode;
}
