package com.tydic.webcenter.manager.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.utils.BeanMapper;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.persistence.model.CityDO;
import com.tydic.webcenter.persistence.service.CityDaoService;
import com.tydic.webcenter.service.model.CityDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/25 12:38
 */
@Service(version = SystemConstant.PERSISTENCE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class CityManagerImpl implements CityManager {

    @Reference(version = SystemConstant.PERSISTENCE_DUBBO_VERSION)
    private CityDaoService cityDaoService;

    @Override
    public Response<List<CityDTO>> getAllCity(CityDTO cityDTO) throws BizException {

        CityDO cityDO = BeanMapper.map(cityDTO, CityDO.class);

        Response<List<CityDO>> response = cityDaoService.getAllCity(cityDO);

        return new Response<List<CityDTO>>(BeanMapper.mapList(response.getResult(), CityDTO.class));
    }

    @Override
    public Response<CityDTO> getById(Long id) throws BizException {

        Response<CityDO> response = cityDaoService.getById(id);

        return new Response<CityDTO>(BeanMapper.map(response.getResult(), CityDTO.class));
    }

    @Override
    public Response<Boolean> deleteById(Long id) throws BizException {
        Response<Boolean> response = cityDaoService.deleteById(id);
        return new Response<Boolean>(response.getResult());
    }

    @Override
    public Response<Boolean> save(CityDTO cityDTO) throws BizException {
        CityDO cityDO = BeanMapper.map(cityDTO, CityDO.class);
        Response<Boolean> response = cityDaoService.save(cityDO);
        return new Response<Boolean>(response.getResult());
    }
}
