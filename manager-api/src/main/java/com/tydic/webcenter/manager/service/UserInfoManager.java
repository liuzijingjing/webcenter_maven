package com.tydic.webcenter.manager.service;

import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.service.model.UserDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 09:51
 */
public interface UserInfoManager {

    public Response<List<UserDTO>> getAll(UserDTO UserInfo) throws BizException;

    public Response<UserDTO> getById(Long id) throws BizException;

    public Response<Boolean> deleteById(Long id) throws BizException;

    public Response<Boolean> save(UserDTO userDTO) throws BizException;
}
