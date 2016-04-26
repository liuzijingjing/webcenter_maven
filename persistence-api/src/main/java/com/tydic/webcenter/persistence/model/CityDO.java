package com.tydic.webcenter.persistence.model;


import lombok.*;

import javax.persistence.Table;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/20 15:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Table(name = "city")
public class CityDO extends BaseDO {

    private String name;

    private String state;

}