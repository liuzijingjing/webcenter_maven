package com.tydic.webcenter.service;

import com.tydic.webcenter.common.utils.BeanMapper;
import com.tydic.webcenter.persistence.model.CityDO;
import com.tydic.webcenter.service.model.CityDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/24 13:36
 */
public class BeanTest {

    public static void main(String[] args) {

        List<CityDO> cls = new ArrayList<CityDO>();
        CityDO cdo = new CityDO();
        cdo.setId(1L);
        cdo.setName("123");
        cdo.setState("456");
        cls.add(cdo);

        CityDO cdo1 = new CityDO();
        cdo1.setId(1L);
        cdo1.setName("678");
        cdo1.setState("432");
        cls.add(cdo1);

        List<CityDTO> bls = BeanMapper.mapList(cls, CityDTO.class);

        System.out.println("ddddddddddddddd");
    }
}
