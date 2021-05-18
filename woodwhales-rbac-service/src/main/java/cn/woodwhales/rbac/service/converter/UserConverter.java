package cn.woodwhales.rbac.service.converter;

import cn.woodwhales.rbac.common.model.vo.UserVO;
import cn.woodwhales.rbac.dao.entity.User;
import org.mapstruct.Mapper;

/**
 * 数据转换器
 * @author woodwhales
 */
@Mapper(componentModel = "spring")
public interface UserConverter extends EntityToVOInterface<User, UserVO> {

    /**
     * entity to VO
     * @param user
     * @return
     */
    @Override
    UserVO convertToVO(User user);

}
