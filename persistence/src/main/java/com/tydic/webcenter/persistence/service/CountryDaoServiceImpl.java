package com.tydic.webcenter.persistence.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.common.utils.VerifyUtil;
import com.tydic.webcenter.persistence.mapper.CountryMapper;
import com.tydic.webcenter.persistence.model.CityDO;
import com.tydic.webcenter.persistence.model.CountryDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 10:15
 */
@Slf4j
@Service(version = SystemConstant.PERSISTENCE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class CountryDaoServiceImpl implements ConuntryDaoService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public Response<List<CountryDO>> getAll(CountryDO countryDO) throws DaoException {
        if (countryDO.getPage() != null && countryDO.getRows() != null) {
            PageHelper.startPage(countryDO.getPage(), countryDO.getRows(), "id");
        }

        List<CountryDO> ls = countryMapper.selectAll();

        return new Response<List<CountryDO>>(ls);
    }

    @Override
    public Response<CountryDO> getById(Long id) throws DaoException {
        return new Response<CountryDO>(countryMapper.selectByPrimaryKey(id));
    }

    @Override
    public Response<Boolean> deleteById(Long id) throws DaoException {
        int result = countryMapper.deleteByPrimaryKey(id);
        VerifyUtil.checkUpdNum(result);
        return new Response<Boolean>(result==1);
    }

    @Override
    public Response<Boolean> save(CountryDO countryDO) throws DaoException {
        int result = 0;
        if (countryDO.getId() != null) {
            result = countryMapper.updateByPrimaryKey(countryDO);
        } else {
            result = countryMapper.insert(countryDO);
        }

        VerifyUtil.checkUpdNum(result);
        return new Response<Boolean>(result==1);
    }
}
