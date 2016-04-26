package com.tydic.webcenter.persistence.service;

import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.persistence.model.CountryDO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 10:03
 */
public interface ConuntryDaoService {

    public Response<List<CountryDO>> getAll(CountryDO countryDO) throws DaoException;

    public Response<CountryDO> getById(Long id) throws DaoException;

    public Response<Boolean> deleteById(Long id) throws DaoException;

    public Response<Boolean> save(CountryDO countryDO) throws DaoException;
}
