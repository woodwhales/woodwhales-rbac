package cn.woodwhales.rbac.common.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author woodwhales on 2021-05-18 17:38
 * @description
 */
@Data
public class UserCreateParam {

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不允许为空")
    private String userName;

    /**
     * 角色id集合
     */
    private List<Long> roleIdList;

}
