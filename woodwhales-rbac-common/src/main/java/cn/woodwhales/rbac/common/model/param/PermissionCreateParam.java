package cn.woodwhales.rbac.common.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author woodwhales on 2021-05-18 17:38
 * @description
 */
@Data
public class PermissionCreateParam {

    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不允许为空")
    private String name;

    /**
     * 权限备注
     */
    private String description;

}
