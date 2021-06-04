package cn.woodwhales.rbac.service.service;

import cn.woodwhales.rbac.dao.entity.Permission;
import cn.woodwhales.rbac.dao.entity.Role;

import java.util.List;

/**
 * @author woodwhales on 2021-06-04 15:41
 * @description
 */
public interface CommonService {

    /**
     * 根据 userId 查询角色集合
     * @param userId
     * @return
     */
    List<Role> getRoleListByUserId(Long userId);

    /**
     * 根据 roleId 查询权限集合
     * @param roleId
     * @return
     */
    List<Permission> getPermissionListByRoleId(Long roleId);

    /**
     * 保存角色权限关系
     * @param roleId
     * @param permissionIdList
     */
    void saveRolePermission(Long roleId, List<Long> permissionIdList);

    /**
     * 保存用户角色关系
     * @param userId
     * @param roleIdList
     */
    void saveUserRole(Long userId, List<Long> roleIdList);

    /**
     * 更新用户角色关系
     * @param userId
     * @param roleIdList
     */
    void updateUserRole(Long userId, List<Long> roleIdList);

    /**
     * 更新角色权限关系
     * @param roleId
     * @param permissionIdList
     */
    void updateRolePermission(Long roleId, List<Long> permissionIdList);
}
