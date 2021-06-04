package cn.woodwhales.rbac.common.model.vo;

import lombok.Data;

/**
 * @author woodwhales on 2021-06-04 16:11
 * @description
 */
@Data
public class RoleSimpleVO {

    /**
     * 角色表主键
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

}
