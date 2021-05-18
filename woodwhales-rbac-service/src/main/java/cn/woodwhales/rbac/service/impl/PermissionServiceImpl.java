package cn.woodwhales.rbac.service.impl;

import cn.woodwhales.rbac.common.model.param.*;
import cn.woodwhales.rbac.common.model.vo.PermissionVO;
import cn.woodwhales.rbac.dao.entity.Permission;
import cn.woodwhales.rbac.dao.mapper.PermissionMapper;
import cn.woodwhales.rbac.service.converter.EntityToVOInterface;
import cn.woodwhales.rbac.service.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.common.model.result.OpResult;
import org.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.mybatisplus.MybatisPlusExecutor;

/**
 * @author woodwhales on 2021-05-18 22:06
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    @Qualifier("permissionConverterImpl")
    private EntityToVOInterface<Permission, PermissionVO> entityToVOInterface;

    @Override
    public PageRespVO<PermissionVO> page(PermissionQueryParam param) {
        return MybatisPlusExecutor.executeQueryPage(permissionMapper, param, wrapper -> {
            wrapper.like(StringUtils.isNotBlank(param.getSearchInfo()), Permission::getName, param.getSearchInfo());
        }, entityToVOInterface::convertToVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public OpResult<Void> create(PermissionCreateParam param) {
        Permission permission = new Permission();
        permission.setName(param.getName());
        permission.setDescription(param.getDescription());
        permissionMapper.insert(permission);
        return OpResult.success();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public OpResult<Void> update(PermissionUpdateParam param) {
        Permission permission = permissionMapper.selectById(param.getId());
        permission.setName(param.getName());
        permission.setDescription(param.getDescription());
        permissionMapper.updateById(permission);
        return OpResult.success();
    }
}
