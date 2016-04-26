package com.tydic.webcenter.service.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tydic.webcenter.common.code.BizErrorCode;
import com.tydic.webcenter.common.utils.ExceptionUtil;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.manager.service.CityManager;
import com.tydic.webcenter.service.model.CityDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/20 15:54
 */
@Slf4j
@Service(version = SystemConstant.SERVICE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class CityServiceImpl implements CityService {

    @Reference(version = SystemConstant.PERSISTENCE_DUBBO_VERSION)
    private CityManager cityManager;

    @Override
    public Response<List<CityDTO>> getAllCity(CityDTO cityDTO) {
        try {
            return cityManager.getAllCity(cityDTO);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<CityDTO> getById(Long id) {
        try {
            return cityManager.getById(id);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<Boolean> deleteById(Long id) {
        try {
            return cityManager.deleteById(id);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<Boolean> save(CityDTO cityDTO) {
        try {
            return cityManager.save(cityDTO);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }
}
