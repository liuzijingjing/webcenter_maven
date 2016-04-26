package com.tydic.webcenter.common.utils;

/**
 * Created by tianshuo on 2016/3/5.
 */
public class SystemConstant {

    //系统配置基本常量
    public static final String MYBATIS_MAPPER_PACKAGE = "com.tydic.webcenter.persistence.mapper";
    public static final String MYBATIS_MAPPER_BASENAME = "com.tydic.webcenter.persistence.utils.BaseMapper";
    public static final String MYBATIS_TYPE_ALIASES_PACKAGE = "com.tydic.webcenter.persistence.model";
    public static final String MYBATIS_MAPPER_LOCATIONS = "classpath:mapper/*.xml";

    //DUBBO 相关
    public static final String PERSISTENCE_DUBBO_VERSION = "1.0.0";
    public static final Integer PERSISTENCE_DUBBO_TIMEOUT = 50000;
    public static final String SERVICE_DUBBO_VERSION = "1.0.0";
    public static final Integer SERVICE_DUBBO_TIMEOUT = 50000;



    /**
     * 公用错误
     */
    public static final String COMMON_ERR = "系统异常,请联系管理员!";

    /**
     * info 级别的日志ID
     */
    public static final String LOG_LEVEL_INFO_ID = "log_info_id";

    /**
     * KAFKA队列组名称
     */
    public static final String MERCHANT_SIGN_KAFKA_GROUP = "PROJECT_NAME_GROUP";

    /**
     * T_USER_LOGIN 表 status 表示可用状态
     */
    public static final String USER_LOGIN_STATUS_ENABLE = "1";

    /**
     * T_USER_LOGIN 表 status 表示不可用状态
     */
    public static final String USER_LOGIN_STATUS_UNENABLE = "0";

    /**
     * 列表数据的日志tostring打印，超过MAX_LOG_DATA_SIZE的设置就不用 [...]来代替
     */
    public static final int MAX_LOG_DATA_SIZE = 20;
}
