package cn.woodwhales.rbac.service.converter;

import cn.woodwhales.rbac.common.model.vo.PermissionVO;
import cn.woodwhales.rbac.dao.entity.Permission;
import org.mapstruct.Mapper;

/**
 * 数据转换器
 * @author woodwhales
 */
@Mapper(componentModel = "spring")
public interface PermissionConverter extends EntityToVOInterface<Permission, PermissionVO> {

    /**
     * entity to VO
     * @param permission
     * @return
     */
    @Override
    PermissionVO convertToVO(Permission permission);

}
