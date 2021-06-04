package cn.woodwhales.rbac.common.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author woodwhales on 2021-05-18 17:38
 * @description
 */
@Data
public class RoleCreateParam {

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不允许为空")
    private String name;

    /**
     * 角色备注
     */
    private String description;

    /**
     * 权限id集合
     */
    private List<Long> permissionIdList;

}
