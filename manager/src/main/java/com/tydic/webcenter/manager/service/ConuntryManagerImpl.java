package com.tydic.webcenter.manager.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.utils.BeanMapper;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.persistence.model.CityDO;
import com.tydic.webcenter.persistence.model.CountryDO;
import com.tydic.webcenter.persistence.service.ConuntryDaoService;
import com.tydic.webcenter.service.model.CityDTO;
import com.tydic.webcenter.service.model.CountryDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 09:52
 */
@Slf4j
@Service(version = SystemConstant.PERSISTENCE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class ConuntryManagerImpl implements ConuntryManager {

    @Reference(version = SystemConstant.PERSISTENCE_DUBBO_VERSION)
    private ConuntryDaoService conuntryDaoService;

    @Override
    public Response<List<CountryDTO>> getAll(CountryDTO countryDTO) throws BizException {
        CountryDO countryDO = BeanMapper.map(countryDTO, CountryDO.class);

        Response<List<CountryDO>> response = conuntryDaoService.getAll(countryDO);

        return new Response<List<CountryDTO>>(BeanMapper.mapList(response.getResult(), CountryDTO.class));
    }

    @Override
    public Response<CountryDTO> getById(Long id) throws BizException {
        Response<CountryDO> response = conuntryDaoService.getById(id);

        return new Response<CountryDTO>(BeanMapper.map(response.getResult(), CountryDTO.class));
    }

    @Override
    public Response<Boolean> deleteById(Long id) throws BizException {
        Response<Boolean> response = conuntryDaoService.deleteById(id);
        return new Response<Boolean>(response.getResult());
    }

    @Override
    public Response<Boolean> save(CountryDTO countryDTO) throws BizException {
        CountryDO countryDO = BeanMapper.map(countryDTO, CountryDO.class);
        Response<Boolean> response = conuntryDaoService.save(countryDO);
        return new Response<Boolean>(response.getResult());
    }
}
