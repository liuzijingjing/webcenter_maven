package com.tydic.webcenter.service.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tydic.webcenter.common.utils.ExceptionUtil;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.manager.service.UserInfoManager;
import com.tydic.webcenter.service.model.UserDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 09:42
 */
@Slf4j
@Service(version = SystemConstant.SERVICE_DUBBO_VERSION, retries = 0, timeout = 50000)
public class UserInfoServiceImpl implements UserInfoService {

    @Reference(version = SystemConstant.SERVICE_DUBBO_VERSION)
    private UserInfoManager userInfoManager;

    @Override
    public Response<List<UserDTO>> getAll(UserDTO UserInfo) {
        try {
            return userInfoManager.getAll(UserInfo);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<UserDTO> getById(Long id) {
        try {
            return userInfoManager.getById(id);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<Boolean> deleteById(Long id) {
        try {
            return userInfoManager.deleteById(id);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }

    @Override
    public Response<Boolean> save(UserDTO userDTO) {
        try {
            return userInfoManager.save(userDTO);
        } catch (Exception e) {
            return ExceptionUtil.doExceptionService(e);
        }
    }
}
