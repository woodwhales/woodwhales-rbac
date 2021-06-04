package cn.woodwhales.rbac.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author woodwhales on 2021-06-04 16:01
 * @description 有效状态：0-有效，1-无效，2-删除
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    /**
     * 有效
     */
    VALID((byte)0, "有效"),

    /**
     * 无效
     */
    INVALID((byte)1, "无效"),

    /**
     * 删除
     */
    DELETED((byte)2, "删除"),
    ;

    private Byte code;
    private String description;
}
