package cn.woodwhales.rbac.common.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author woodwhales on 2021-06-04 15:32
 * @description
 */
@Data
@NoArgsConstructor
public class UserDetailVO extends UserVO {

    /**
     * 角色集合
     */
    private List<RoleSimpleVO> roleList;

}
