package com.tydic.webcenter.common.code;


/**
 * 业务异常
 * User: Wilin Date: 2016/03/09 ProjectName: merchant Version: 1.0
 */
public enum BizErrorCode implements ErrorCode {

    /**
     * 调用远程服务返回结果为空，定义为系统异常，可尝试重新发起
     */
    REMOTE_RESPONSE_NULL_EXCEPTION("REMOTE_RESPONSE_NULL_EXCEPTION", "系统异常，请确认请求是否成功再尝试发起"),

    /**
     * 请求远程服务超时,最常见的RpcException，如果是dubbo调用超时则返回系统超时
     */
    REMOTE_TIMEOUT_ERROR("REMOTE_TIMEOUT_ERROR", "请求远程服务超时"),

    /**
     * 执行数据库操作发生异常,具体查看数据库返回的异常信息
     */
    DATA_BASE_ERROR("DATA_BASE_ERROR", "数据库操作异常"),

    /**
     * 数据更新失败
     */
    DATA_UPDATE_ERROR("DATA_UPDATE_ERROR", "数据更新失败"),

    /**
     * 参数校验不通过 ，未明确具体参数的情况使用该枚举
     */
    PARAMETER_VALID_NOT_PASS("PARAMETER_VALID_NOT_PASS", "参数校验不通过"),

    /**
     * 参数对象内部属性校验不通过 ，不同于参数对象本身校验
     */
    PARAMETER_FIELD_VALID_NOT_PASS("PARAMETER_FIELD_VALID_NOT_PASS", " 参数对象内部属性校验不通过"),

    /**
     * 参数为空（含null）是非法的
     */
    BLANK_IS_ILLEGAL_PARAM("BLANK_IS_ILLEGAL_PARAM", "参数为空（含null）是非法的"),

    /**
     * 参数为null（不含空字符串）是非法的
     */
    NULL_IS_ILLEGAL_PARAM("NULL_IS_ILLEGAL_PARAM", "参数为null是非法的"),

    /**
     * fastdfs 文件上传失败
     */
    FILE_UPLOAD_ERROR("FILE_UPLOAD_ERROR", "文件上传失败"),

    /**
     * fastdfs 文件下传失败
     */
    FILE_DOWNLOAD_ERROR("FILE_DOWNLOAD_ERROR", "文件下传失败"),

    /**
     * fastdfs 文件删除失败
     */
    FILE_DELETE_ERROR("FILE_DELETE_ERROR", "文件删除失败"),

    /**
     * fastdfs 文件不存在
     */
    FILE_NOT_EXIT("FILE_NOT_EXIT", "文件不存在"),

    /**
     * 文件类型不正确
     */
    FILE_FILETYPE_ERROR("800008", "文件类型不正确"),

    /**
     * 根据查询参数没有找到匹配的记录
     */
    EMPTY_QUERY_RESULT("EMPTY_QUERY_RESULT", "查询结果为空"),

    API_INVOKE_FAIL("API_INVOKE_FAIL", "接口返回同步失败"),

    /**
     * 该错误码一般是在系统内部处理过程中出现不需要外部系统明确了解（如模型转化错误，非对外服务参数校验不同，内部BUG）时设定的错误码
     */
    SYSTEM_INNER_ERROR("SYSTEM_INNER_ERROR", "系统内部错误");

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常描述
     */
    private String desc;

    BizErrorCode(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

}
