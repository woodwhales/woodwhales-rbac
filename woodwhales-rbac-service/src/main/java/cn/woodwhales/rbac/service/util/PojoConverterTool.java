package cn.woodwhales.rbac.service.util;

import cn.woodwhales.rbac.common.model.vo.PermissionSimpleVO;
import cn.woodwhales.rbac.common.model.vo.RoleDetailVO;
import cn.woodwhales.rbac.common.model.vo.RoleSimpleVO;
import cn.woodwhales.rbac.common.model.vo.UserDetailVO;
import cn.woodwhales.rbac.dao.entity.Permission;
import cn.woodwhales.rbac.dao.entity.Role;
import cn.woodwhales.rbac.dao.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static org.woodwhales.business.DataTool.toList;

/**
 * @author woodwhales on 2021-06-04 16:15
 * @description
 */
public class PojoConverterTool {

    private PojoConverterTool() {

    }

    public static RoleSimpleVO buildRoleSimpleVO(Role role) {
        RoleSimpleVO roleSimpleVO = new RoleSimpleVO();
        BeanUtils.copyProperties(role, roleSimpleVO);
        return roleSimpleVO;
    }

    public static UserDetailVO buildUserDetailVO(User user, List<Role> roleList) {
        UserDetailVO userDetailVO = new UserDetailVO();
        BeanUtils.copyProperties(user, userDetailVO);
        userDetailVO.setRoleList(toList(roleList, PojoConverterTool::buildRoleSimpleVO));
        return userDetailVO;
    }

    public static RoleDetailVO buildRoleDetailVO(Role role, List<Permission> permissionList) {
        RoleDetailVO roleDetailVO = new RoleDetailVO();
        BeanUtils.copyProperties(role, roleDetailVO);
        roleDetailVO.setPermissionList(toList(permissionList, PojoConverterTool::buildPermissionSimpleVO));
        return roleDetailVO;
    }

    private static PermissionSimpleVO buildPermissionSimpleVO(Permission permission) {
        PermissionSimpleVO permissionSimpleVO = new PermissionSimpleVO();
        BeanUtils.copyProperties(permission, permissionSimpleVO);
        return permissionSimpleVO;
    }
}
