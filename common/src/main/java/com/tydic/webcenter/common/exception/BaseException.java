package com.tydic.webcenter.common.exception;

import com.tydic.webcenter.common.code.ErrorCode;
import com.tydic.webcenter.common.utils.MessageHelper;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义基础异常
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1279879878978686L;

    private static final String MSG_TEMPLATE = "错误码:{0}, 描述:{1}, 异常信息:{2}";

    @Getter
    private ErrorCode errorCode;

    @Getter
    @Setter
    private String extraMsg;


    public BaseException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public BaseException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(getMessage(errorCode, extraMsg), cause);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
    }

    public BaseException(ErrorCode errorCode) {
        this(errorCode, null, (Throwable) null);
    }

    public BaseException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, (Throwable) null);
    }

    private static String getMessage(ErrorCode errorCode, String extraMessage) {
        extraMessage = null != extraMessage ? extraMessage : "";
        return MessageHelper.formatMsg("错误码:{0}, 描述:{1}, 异常信息:{2}",
                new Object[]{errorCode.getCode(), errorCode.getDesc(), extraMessage});
    }
}