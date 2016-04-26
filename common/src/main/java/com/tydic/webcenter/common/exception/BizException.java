package com.tydic.webcenter.common.exception;

import com.tydic.webcenter.common.code.ErrorCode;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/18 13:24
 */
public class BizException extends BaseException {

    public BizException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public BizException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    public BizException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    public BizException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }
}
