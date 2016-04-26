package com.tydic.webcenter.manager.service;

import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.service.model.CountryDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 09:52
 */
public interface ConuntryManager {

    public Response<List<CountryDTO>> getAll(CountryDTO country) throws BizException;

    public Response<CountryDTO> getById(Long id) throws BizException;

    public Response<Boolean> deleteById(Long id) throws BizException;

    public Response<Boolean> save(CountryDTO country) throws BizException;
}
