package cn.woodwhales.rbac.common.model.vo;

import lombok.Data;

/**
 * @author woodwhales on 2021-05-18 16:37
 * @description
 */
@Data
public class RoleVO {

    /**
     * 角色表主键
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色备注
     */
    private String description;

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
