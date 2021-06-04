package cn.woodwhales.rbac.service.impl;

import cn.woodwhales.rbac.common.enums.StatusEnum;
import cn.woodwhales.rbac.common.model.entity.BaseEntity;
import cn.woodwhales.rbac.dao.batchmapper.BatchRolePermissionMapper;
import cn.woodwhales.rbac.dao.batchmapper.BatchUserRoleMapper;
import cn.woodwhales.rbac.dao.entity.Permission;
import cn.woodwhales.rbac.dao.entity.Role;
import cn.woodwhales.rbac.dao.entity.RolePermission;
import cn.woodwhales.rbac.dao.entity.UserRole;
import cn.woodwhales.rbac.dao.mapper.PermissionMapper;
import cn.woodwhales.rbac.dao.mapper.RoleMapper;
import cn.woodwhales.rbac.dao.mapper.RolePermissionMapper;
import cn.woodwhales.rbac.dao.mapper.UserRoleMapper;
import cn.woodwhales.rbac.service.service.CommonService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.business.DataTool;
import org.woodwhales.business.collection.CollectionMathResult;
import org.woodwhales.mybatisplus.MybatisPlusExecutor;

import java.util.List;
import java.util.function.Function;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

/**
 * @author woodwhales on 2021-06-04 15:41
 * @description
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private BatchUserRoleMapper batchUserRoleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private BatchRolePermissionMapper batchRolePermissionMapper;

    @Override
    public List<Role> getRoleListByUserId(Long userId) {
        if(isNull(userId)) {
            return emptyList();
        }
        List<UserRole> userRoleList = MybatisPlusExecutor.executeQueryList(userRoleMapper, wrapper -> {
            wrapper.eq(UserRole::getUserId, userId)
                    .eq(BaseEntity::getStatus, StatusEnum.VALID.getCode());
        });
        if(isNotEmpty(userRoleList)) {
            return roleMapper.selectBatchIds(DataTool.toList(userRoleList, UserRole::getRoleId, true));
        }
        return emptyList();
    }

    @Override
    public List<Permission> getPermissionListByRoleId(Long roleId) {
        if(isNull(roleId)) {
            return emptyList();
        }
        List<RolePermission> rolePermissionList = MybatisPlusExecutor.executeQueryList(rolePermissionMapper, wrapper -> {
            wrapper.eq(RolePermission::getRoleId, roleId)
                   .eq(BaseEntity::getStatus, StatusEnum.VALID.getCode());
        });
        if(isNotEmpty(rolePermissionList)) {
            return permissionMapper.selectBatchIds(DataTool.toList(rolePermissionList, RolePermission::getPermissionId, true));
        }
        return emptyList();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public void saveRolePermission(Long roleId, List<Long> permissionIdList) {
        if(isEmpty(permissionIdList)) {
            return;
        }
        Preconditions.checkNotNull(roleId, "roleId不允许为空");
        List<RolePermission> rolePermissionList = DataTool.toList(permissionIdList, permissionId -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermission.setStatus(StatusEnum.VALID.getCode());
            return rolePermission;
        });
        batchRolePermissionMapper.saveBatch(rolePermissionList);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public void saveUserRole(Long userId, List<Long> roleIdList) {
        if(isEmpty(roleIdList)) {
            return;
        }
        Preconditions.checkNotNull(userId, "userId不允许为空");
        List<UserRole> userRoleList = DataTool.toList(roleIdList, roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRole.setStatus(StatusEnum.VALID.getCode());
            return userRole;
        });
        batchUserRoleMapper.saveBatch(userRoleList);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public void updateUserRole(Long userId, List<Long> roleIdList) {
        Preconditions.checkNotNull(userId, "userId不允许为空");

        List<UserRole> userRoleList = MybatisPlusExecutor.executeQueryList(userRoleMapper,
                                                                           wrapper -> wrapper.eq(UserRole::getUserId, userId)
                                                                                             .eq(BaseEntity::getStatus,
                                                                                                 StatusEnum.VALID.getCode()));

        CollectionMathResult<Long, Long, UserRole> compute = CollectionMathResult.compute(roleIdList, Function.identity(),
                                                                                          userRoleList, UserRole::getRoleId);

        // 请求多，保存
        List<Long> saveRoleIdList = compute.getPositiveDifferenceList();
        saveUserRole(userId, saveRoleIdList);

        // 数据库多，删除
        List<UserRole> deleteUserRoleList = compute.getNegativeDifferenceList();
        deleteUserRole(deleteUserRoleList);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public void updateRolePermission(Long roleId, List<Long> permissionIdList) {
        Preconditions.checkNotNull(roleId, "roleId不允许为空");
        List<RolePermission> rolePermissionList = MybatisPlusExecutor.executeQueryList(rolePermissionMapper,
                                                                                    wrapper -> wrapper.eq(RolePermission::getRoleId,
                                                                                                          roleId)
                                                                                                      .eq(BaseEntity::getStatus,
                                                                                                          StatusEnum.VALID.getCode()));

        CollectionMathResult<Long, Long, RolePermission> compute = CollectionMathResult.compute(permissionIdList, Function.identity(),
                                                                                                rolePermissionList,
                                                                                                RolePermission::getPermissionId);

        // 请求多，保存
        List<Long> savePermissionIdList = compute.getPositiveDifferenceList();
        saveRolePermission(roleId, savePermissionIdList);

        // 数据库多，删除
        List<RolePermission> deleteRolePermissionList = compute.getNegativeDifferenceList();
        deleteRolePermission(deleteRolePermissionList);
    }

    private void deleteRolePermission(List<RolePermission> deleteRolePermissionList) {
        if(isNotEmpty(deleteRolePermissionList)) {
            for (RolePermission rolePermission : deleteRolePermissionList) {
                rolePermission.setStatus(StatusEnum.DELETED.getCode());
            }
            batchRolePermissionMapper.updateBatchById(deleteRolePermissionList);
        }
    }

    private void deleteUserRole(List<UserRole> deleteUserRoleList) {
        if(isNotEmpty(deleteUserRoleList)) {
            for (UserRole userRole : deleteUserRoleList) {
                userRole.setStatus(StatusEnum.DELETED.getCode());
            }
            batchUserRoleMapper.updateBatchById(deleteUserRoleList);
        }
    }
}
