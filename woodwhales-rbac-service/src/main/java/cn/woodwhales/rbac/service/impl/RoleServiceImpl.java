package cn.woodwhales.rbac.service.impl;

import cn.woodwhales.rbac.common.enums.StatusEnum;
import cn.woodwhales.rbac.common.model.entity.BaseEntity;
import cn.woodwhales.rbac.common.model.param.RoleCreateParam;
import cn.woodwhales.rbac.common.model.param.RoleQueryParam;
import cn.woodwhales.rbac.common.model.param.RoleUpdateParam;
import cn.woodwhales.rbac.common.model.vo.RoleDetailVO;
import cn.woodwhales.rbac.common.model.vo.RoleVO;
import cn.woodwhales.rbac.dao.entity.Permission;
import cn.woodwhales.rbac.dao.entity.Role;
import cn.woodwhales.rbac.dao.mapper.RoleMapper;
import cn.woodwhales.rbac.service.converter.EntityToVOInterface;
import cn.woodwhales.rbac.service.service.CommonService;
import cn.woodwhales.rbac.service.service.RoleService;
import cn.woodwhales.rbac.service.util.PojoConverterTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.common.model.result.OpResult;
import org.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.mybatisplus.MybatisPlusExecutor;

import java.util.List;

/**
 * @author woodwhales on 2021-05-18 16:46
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    @Qualifier("roleConverterImpl")
    private EntityToVOInterface<Role, RoleVO> entityToVOInterface;

    @Autowired
    private CommonService commonService;

    @Override
    public PageRespVO<RoleVO> page(RoleQueryParam param) {
        return MybatisPlusExecutor.executeQueryPage(roleMapper, param, wrapper -> {
            wrapper.like(StringUtils.isNotBlank(param.getSearchInfo()), Role::getName, param.getSearchInfo())
                   .eq(BaseEntity::getStatus, StatusEnum.VALID.getCode());
        }, entityToVOInterface::convertToVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public OpResult<Void> create(RoleCreateParam param) {
        Role role = new Role();
        role.setName(param.getName());
        role.setDescription(param.getDescription());
        roleMapper.insert(role);
        commonService.saveRolePermission(role.getId(), param.getPermissionIdList());
        return OpResult.success();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public OpResult<Void> update(RoleUpdateParam param) {
        Role role = roleMapper.selectById(param.getId());
        role.setName(param.getName());
        role.setDescription(param.getDescription());
        roleMapper.updateById(role);
        commonService.updateRolePermission(role.getId(), param.getPermissionIdList());
        return OpResult.success();
    }

    @Override
    public OpResult<RoleDetailVO> detail(Long roleId) {
        Role role = roleMapper.selectById(roleId);
        List<Permission> permissionList = commonService.getPermissionListByRoleId(roleId);
        return OpResult.success(PojoConverterTool.buildRoleDetailVO(role, permissionList));
    }

}
