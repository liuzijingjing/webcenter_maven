package com.tydic.webcenter.manager.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.utils.BeanMapper;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.persistence.model.CountryDO;
import com.tydic.webcenter.persistence.model.UserDO;
import com.tydic.webcenter.persistence.service.UserInfoDaoService;
import com.tydic.webcenter.service.model.CountryDTO;
import com.tydic.webcenter.service.model.UserDTO;
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
public class UserInfoManagerImpl implements UserInfoManager {

    @Reference(version = SystemConstant.PERSISTENCE_DUBBO_VERSION)
    private UserInfoDaoService userInfoDaoService;


    @Override
    public Response<List<UserDTO>> getAll(UserDTO userDTO) throws BizException {
        UserDO userDO = BeanMapper.map(userDTO, UserDO.class);
        Response<List<UserDO>> response = userInfoDaoService.getAll(userDO);

        return new Response<List<UserDTO>>(BeanMapper.mapList(response.getResult(), UserDTO.class));
    }

    @Override
    public Response<UserDTO> getById(Long id) throws BizException {
        Response<UserDO> response = userInfoDaoService.getById(id);

        return new Response<UserDTO>(BeanMapper.map(response.getResult(), UserDTO.class));
    }

    @Override
    public Response<Boolean> deleteById(Long id) throws BizException {
        Response<Boolean> response = userInfoDaoService.deleteById(id);
        return new Response<Boolean>(response.getResult());
    }

    @Override
    public Response<Boolean> save(UserDTO userDTO) throws BizException {
        UserDO userDO = BeanMapper.map(userDTO, UserDO.class);
        Response<Boolean> response = userInfoDaoService.save(userDO);
        return new Response<Boolean>(response.getResult());
    }
}
