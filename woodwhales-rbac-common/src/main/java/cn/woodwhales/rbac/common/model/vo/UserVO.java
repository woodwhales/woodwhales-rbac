package cn.woodwhales.rbac.common.model.vo;

import lombok.Data;

/**
 * @author woodwhales on 2021-05-18 21:09
 * @description
 */
@Data
public class UserVO {

    /**
     * 用户表主键
     */
    private Long id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 有效状态：0-有效，1-无效，2-删除
     */
    private Byte status;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    private java.util.Date updateTime;

}
