package com.tydic.webcenter.persistence.model;

import lombok.*;

import javax.persistence.Table;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 10:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Table(name = "country")
public class CountryDO extends BaseDO {

    /**
     * 名称
     */
    private String countryname;

    /**
     * 代码
     */
    private String countrycode;
}
