package com.tydic.webcenter.common.utils;

import com.tydic.webcenter.common.code.BizErrorCode;
import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.exception.DaoException;
import com.tydic.webcenter.common.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/18 11:46
 */
public class ExceptionUtil {

    /**
     * 统一异常处理
     *
     * @param err 异常
     * @return 外部响应对象
     */
    public static <T> Response<T> doExceptionService(Throwable err) {

        //persistence层异常
        if (err instanceof DaoException) {
            DaoException e = (DaoException) err;
            return new Response<T>(e.getErrorCode().getCode(),
                    StringUtils.isBlank(e.getExtraMsg()) ? e.getErrorCode().getDesc() : e.getExtraMsg());
        }
        //manager层异常
        if (err instanceof BizException) {
            BizException e = (BizException) err;
            return new Response<T>(e.getErrorCode().getCode(),
                    StringUtils.isBlank(e.getExtraMsg()) ? e.getErrorCode().getDesc() : e.getExtraMsg());
        }
        //service异常
        if (err instanceof ServiceException) {
            ServiceException e = (ServiceException) err;
            return new Response<T>(e.getErrorCode().getCode(),
                    StringUtils.isBlank(e.getExtraMsg()) ? e.getErrorCode().getDesc() : e.getExtraMsg());
        }
        //参数异常
        if (err instanceof IllegalArgumentException) {
            return new Response<T>(BizErrorCode.PARAMETER_VALID_NOT_PASS.getCode(),
                    BizErrorCode.PARAMETER_VALID_NOT_PASS.getDesc());
        }

        return new Response<T>(BizErrorCode.SYSTEM_INNER_ERROR.getCode(), BizErrorCode.SYSTEM_INNER_ERROR.getDesc());
    }
}
