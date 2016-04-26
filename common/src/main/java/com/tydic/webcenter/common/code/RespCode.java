package com.tydic.webcenter.common.code;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/24 17:46
 */
@ToString
public enum RespCode implements ErrorCode {

    OPERA_FAIL("BS061000", "操作失败"),
    BIND_REFUND_EXCEPTION("BF9999", "系统忙，请稍后重试"),
    BF999999("BF999999", "系统繁忙，请稍后再试。"),
    RESSUCCESS("00000000", "成功"),

    DB_QUERY_ERROR("PR0001","查询失败"),
    DB_UPDATE_ERROR("PR0001","更新失败"),
    DB_INSERT_ERROR("PR0001","插入失败"),
    DB_DELETE_ERROR("PR0001","删除失败"),

    /**
     * 系统繁忙
     */
    EASYMSG_BUSY_ERR("9999", "系统繁忙，请稍后再试。"),
    /**
     * 系统繁忙
     */
    EASYMSG_SUCCESS("000000", "业务成功"),
    /**
     * 业务：系统异常
     */
    EASYMSG_BS081022("BS081022", "业务：系统异常"),
    /**
     * 验证码不正确
     */
    EASYMSG_CHK_ERR("-802", "您输入的验证码不正确。"),
    /**
     * 验证码格式不正确
     */
    EASYMSGFORMAT_ERR("-802", "您输入的验证码格式不正确。"),
    /**
     * 校验验证码成功
     */
    EASYMSG_CHK_SUCCESS("0000", "校验验证码成功。"),
    /**
     * 验证码失效
     */
    EASYMSG_CHKCODE_INVALID("-802", "您输入的验证码已失效，有效期为5分钟，请重新回复BD+手机号(如：BD18900000000)，绑定翼支付哦！"),
    /**
     * 校验成功
     */
    EASYMSG_VAIL_SUCCESS("0000", "验证成功"),

    ERR_PARAM("1903", "参数校验失败"),
    ERR_PARAM7("1907", "参数校验失败"),
    ERR_REQ_XML("1902", "报文解析错误(request_xml不符合规定)"),
    ERR_DATA_SIGN("1901", "数据签名或验签错误"),
    ERR_ENC_DEC("1905", "报文加密或解密错误"),
    ERR_SYSTEM("1900", "系统错误"),
    ERR_SER_TYPE("1904", "服务类型错误"),
    ERR_VALIDATE("1903", "参数较验失败"),

    /**
     * dubbo 接入服务响应解释
     */
    DUBBO_INVOKE_SUCCESS("0000", "服务调用成功响应结果为空"),
    DUBBO_INVOKE_ERROR("9999", "服务调用失败");


    /**
     * 异常码
     */
    @Getter
    @Setter
    private String code;

    /**
     * 异常描述
     */
    @Getter
    @Setter
    private String desc;

    RespCode(String code, String desc) {
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

    public static RespCode from(String code) {
        for (RespCode respCode : RespCode.values()) {
            if (Objects.equal(respCode.getCode(), code)) {
                return respCode;
            }
        }
        return null;
    }

    public static String getRespCodeAndDesc(RespCode respCode) {
        return respCode.getCode() + respCode.getDesc();
    }

    public static String getRespCodeAndDesc(RespCode respCode, String respDesc) {
        return respCode.getCode() + ":" + respDesc;
    }
}
