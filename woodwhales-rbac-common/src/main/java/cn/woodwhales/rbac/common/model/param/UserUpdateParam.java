package cn.woodwhales.rbac.common.model.param;

import lombok.Data;

/**
 * @author woodwhales on 2021-05-18 17:51
 * @description
 */
@Data
public class UserUpdateParam extends UserCreateParam {

    /**
     * 用户表主键
     */
    private Long id;

}
