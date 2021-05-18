package cn.woodwhales.rbac.common.enums;

import org.woodwhales.common.model.result.BaseRespResult;

/**
 * @author woodwhales on 2021-05-18 16:19
 * @description
 */
public enum GlobalErrorEnum implements BaseRespResult {


    SUCCESS(0, "操作成功"),
    ERROR(-1, "操作失败"),
    NPE(10001, "空指针异常"),
    REQUEST_METHOD_ERROR(10002, "请求方式错误"),
    ;

    private final Integer code;
    private final String message;

    private GlobalErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getCode() {
        return this.code;
    }

}
