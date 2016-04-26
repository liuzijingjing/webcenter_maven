package com.tydic.webcenter.service.demo;

import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.service.model.UserDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/26 09:40
 */
public interface UserInfoService {

    public Response<List<UserDTO>> getAll(UserDTO UserInfo) ;

    public Response<UserDTO> getById(Long id) ;

    public Response<Boolean> deleteById(Long id) ;

    public Response<Boolean> save(UserDTO userDTO) ;
}
