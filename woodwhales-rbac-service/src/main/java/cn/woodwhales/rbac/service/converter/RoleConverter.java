package cn.woodwhales.rbac.service.converter;

import cn.woodwhales.rbac.common.model.vo.RoleVO;
import cn.woodwhales.rbac.dao.entity.Role;
import org.mapstruct.Mapper;

/**
 * 数据转换器
 * @author woodwhales
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    /**
     * entity to VO
     * @param role
     * @return
     */
    RoleVO convertToVO(Role role);

}
