package cn.woodwhales.rbac.common.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author woodwhales on 2021-06-04 16:22
 * @description
 */
@Data
public class RoleDetailVO extends RoleVO {

    /**
     * 角色权限集合
     */
    private List<PermissionSimpleVO> permissionList;

}
