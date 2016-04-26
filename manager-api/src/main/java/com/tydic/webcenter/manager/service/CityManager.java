package com.tydic.webcenter.manager.service;

import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.service.model.CityDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/25 12:39
 */
public interface CityManager {

    public Response<List<CityDTO>> getAllCity(CityDTO cityDTO) throws BizException;

    public Response<CityDTO> getById(Long id) throws BizException;

    public Response<Boolean> deleteById(Long id) throws BizException;

    public Response<Boolean> save(CityDTO cityDTO) throws BizException;
}
