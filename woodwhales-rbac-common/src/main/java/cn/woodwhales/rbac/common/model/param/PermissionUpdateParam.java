package cn.woodwhales.rbac.common.model.param;

import lombok.Data;

import java.util.List;

/**
 * @author woodwhales on 2021-05-18 17:51
 * @description
 */
@Data
public class PermissionUpdateParam extends PermissionCreateParam {

    /**
     * 权限表主键
     */
    private Long id;

    /**
     * 权限id集合
     */
    private List<Long> permissionList;

}
