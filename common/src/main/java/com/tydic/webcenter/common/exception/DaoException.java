package com.tydic.webcenter.common.exception;

import com.tydic.webcenter.common.code.ErrorCode;
import com.tydic.webcenter.common.code.RespCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by zhangls on 14-4-27.
 */
@ToString
public class DaoException extends BaseException {

    public DaoException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public DaoException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    public DaoException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    public DaoException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }

}
