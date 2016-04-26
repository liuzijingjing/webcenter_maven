package com.tydic.webcenter.service.demo;

import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.service.model.CityDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/17 20:36
 */
public interface CityService {

    public Response<List<CityDTO>> getAllCity(CityDTO cityDTO) ;

    public Response<CityDTO> getById(Long id);

    public Response<Boolean> deleteById(Long id);

    public Response<Boolean> save(CityDTO cityDTO);
}
