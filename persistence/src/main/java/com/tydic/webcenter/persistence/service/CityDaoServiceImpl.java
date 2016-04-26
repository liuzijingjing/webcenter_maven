package com.tydic.webcenter.persistence.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.common.utils.VerifyUtil;
import com.tydic.webcenter.persistence.mapper.CityMapper;
import com.tydic.webcenter.persistence.model.CityDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/22 14:20
 */
@Slf4j
@Service(version = SystemConstant.PERSISTENCE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class CityDaoServiceImpl implements CityDaoService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Response<List<CityDO>> getAllCity(CityDO cityDO) throws DaoException {
        if (cityDO.getPage() != null && cityDO.getRows() != null) {
            PageHelper.startPage(cityDO.getPage(), cityDO.getRows(), "id");
        }

        List<CityDO> ls = cityMapper.selectAll();

        return new Response<List<CityDO>>(ls);
    }

    @Override
    public Response<CityDO> getById(Long id) throws DaoException {
        return new Response<CityDO>(cityMapper.selectByPrimaryKey(id));
    }

    @Override
    public Response<Boolean> deleteById(Long id) throws DaoException {
        int result = cityMapper.deleteByPrimaryKey(id);
        VerifyUtil.checkUpdNum(result);
        return new Response<Boolean>(result==1);
    }

    @Override
    public Response<Boolean> save(CityDO cityDO) throws DaoException {
        int result = 0;
        if (cityDO.getId() != null) {
            result = cityMapper.updateByPrimaryKey(cityDO);
        } else {
            result = cityMapper.insert(cityDO);
        }

        VerifyUtil.checkUpdNum(result);
        return new Response<Boolean>(result==1);
    }
}
