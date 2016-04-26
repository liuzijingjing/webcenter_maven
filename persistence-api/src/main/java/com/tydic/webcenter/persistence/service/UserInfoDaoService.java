package com.tydic.webcenter.persistence.service;

import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.persistence.model.UserDO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 10:04
 */
public interface UserInfoDaoService {

    public Response<List<UserDO>> getAll(UserDO userDO) throws DaoException;

    public Response<UserDO> getById(Long id) throws DaoException;

    public Response<Boolean> deleteById(Long id) throws DaoException;

    public Response<Boolean> save(UserDO userDO) throws DaoException;
}
