package cn.woodwhales.rbac.common.model.vo;

import lombok.Data;

/**
 * @author woodwhales on 2021-06-04 16:23
 * @description
 */
@Data
public class PermissionSimpleVO {

    /**
     * 权限表主键
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

}
