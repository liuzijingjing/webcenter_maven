package com.tydic.webcenter.service.demo;

import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.service.model.CountryDTO;

import java.util.List;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/25 16:27
 */
public interface CountryService {

    public Response<List<CountryDTO>> getAll(CountryDTO country) ;

    public Response<CountryDTO> getById(Long id) ;

    public Response<Boolean> deleteById(Long id) ;

    public Response<Boolean> save(CountryDTO country) ;
}
