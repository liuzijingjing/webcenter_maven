package com.tydic.webcenter.persistence.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.common.utils.VerifyUtil;
import com.tydic.webcenter.persistence.mapper.UserMapper;
import com.tydic.webcenter.persistence.model.CountryDO;
import com.tydic.webcenter.persistence.model.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 10:16
 */
@Slf4j
@Service(version = SystemConstant.PERSISTENCE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class UserInfoDaoServiceImpl implements UserInfoDaoService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response<List<UserDO>> getAll(UserDO userDO) throws DaoException {
        if (userDO.getPage() != null && userDO.getRows() != null) {
            PageHelper.startPage(userDO.getPage(), userDO.getRows(), "id");
        }

        List<UserDO> ls = userMapper.selectAll();

        return new Response<List<UserDO>>(ls);
    }

    @Override
    public Response<UserDO> getById(Long id) throws DaoException {
        return new Response<UserDO>(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public Response<Boolean> deleteById(Long id) throws DaoException {
        int result = userMapper.deleteByPrimaryKey(id);
        VerifyUtil.checkUpdNum(result);
        return new Response<Boolean>(result==1);
    }

    @Override
    public Response<Boolean> save(UserDO userDO) throws DaoException {
        int result = 0;
        if (userDO.getId() != null) {
            result = userMapper.updateByPrimaryKey(userDO);
        } else {
            result = userMapper.insert(userDO);
        }

        VerifyUtil.checkUpdNum(result);
        return new Response<Boolean>(result==1);
    }
}
