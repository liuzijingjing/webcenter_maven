package com.tydic.webcenter.service.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tydic.webcenter.common.utils.ExceptionUtil;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.manager.service.ConuntryManager;
import com.tydic.webcenter.service.model.CountryDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 09:56
 */
@Slf4j
@Service(version = SystemConstant.SERVICE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class CountryServiceImpl implements CountryService {

    @Reference(version = SystemConstant.SERVICE_DUBBO_VERSION)
    private ConuntryManager conuntryManager;

    @Override
    public Response<List<CountryDTO>> getAll(CountryDTO country) {
        try {
            return conuntryManager.getAll(country);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<CountryDTO> getById(Long id) {
        try {
            return conuntryManager.getById(id);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<Boolean> deleteById(Long id) {
        try {
            return conuntryManager.deleteById(id);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<Boolean> save(CountryDTO country) {
        try {
            return conuntryManager.save(country);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }
}
