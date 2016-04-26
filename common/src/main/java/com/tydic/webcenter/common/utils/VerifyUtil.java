package com.tydic.webcenter.common.utils;

import com.tydic.webcenter.common.code.BizErrorCode;
import com.tydic.webcenter.common.exception.BizException;
import com.tydic.webcenter.common.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * 参数校验服务
 * <p>
 * 1、请求参数非空、格式验证，请求对象
 * 2、校验参数是否非空
 * 3、字符串参数是否非空
 * 4、检查数据库更新记录操作数
 * 5、字符串参数长度校验
 * </p>
 * User: zhangls Date: 2016/03/09  Version: 1.0
 */
@Slf4j
public class VerifyUtil {

    private static Validator validator = new Validator();

    /**
     * 1、请求参数非空、格式验证，请求对象
     *
     * @param object 请求校验参数
     */
    public static void validateObject(Object object) throws Exception {
        List<ConstraintViolation> list = validator.validate(object);
        if (null != list && !list.isEmpty()) {
//            log.info("校验参数异常:{}", list.get(0).getMessage());
            
            throw new BizException(BizErrorCode.PARAMETER_VALID_NOT_PASS, list.get(0).getMessage());
        }
    }

    /**
     * 2、校验参数是否非空
     *
     * @param object 待验证对象
     * @throws BizException 参数为空
     */
    public static void validateNull(Object object) throws Exception {
        if (object == null) {
            throw new BizException(BizErrorCode.NULL_IS_ILLEGAL_PARAM);
        }
    }

    /**
     * 3、字符串参数是否非空
     *
     * @param params 待验证参数
     * @throws BizException 参数为空
     */
    public static void validateStringNull(String... params) throws BizException {
        for (String param : params) {
            if (StringUtils.isEmpty(param)) {
                throw new BizException(BizErrorCode.BLANK_IS_ILLEGAL_PARAM);
            }
        }
    }

    /**
     * 4、检查数据库更新记录操作数
     *
     * @param updNum 更新数
     */
    public static void checkUpdNum(int updNum) {
        if (updNum < 1) {
            throw new DaoException(BizErrorCode.DATA_UPDATE_ERROR);
        }
    }

    /**
     * 5、字符串参数长度校验
     *
     * @param param 待验证参数
     * @throws BizException
     */
    public static void validateStringLength(String param, int maxLenth) throws BizException {
        if (StringUtils.isNotEmpty(param) && param.length() > maxLenth) {
            throw new BizException(BizErrorCode.PARAMETER_VALID_NOT_PASS, param + "超过最大长度：" + maxLenth);
        }
    }

}


