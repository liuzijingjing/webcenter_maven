package com.tydic.webcenter.persistence.service;

import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.persistence.model.CityDO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/22 14:19
 */
public interface CityDaoService {

    public Response<List<CityDO>> getAllCity(CityDO cityDO) throws DaoException;

    public Response<CityDO> getById(Long id) throws DaoException;

    public Response<Boolean> deleteById(Long id) throws DaoException;

    public Response<Boolean> save(CityDO cityDO) throws DaoException;
}
