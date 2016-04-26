package com.tydic.webcenter.common.exception;

import com.tydic.webcenter.common.code.ErrorCode;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/18 13:25
 */
public class ServiceException extends BaseException {

    public ServiceException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public ServiceException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    public ServiceException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    public ServiceException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }
}
