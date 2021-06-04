package cn.woodwhales.rbac.web.controller;

import cn.woodwhales.rbac.common.model.param.RoleCreateParam;
import cn.woodwhales.rbac.common.model.param.RoleQueryParam;
import cn.woodwhales.rbac.common.model.param.RoleUpdateParam;
import cn.woodwhales.rbac.common.model.vo.RoleDetailVO;
import cn.woodwhales.rbac.common.model.vo.RoleVO;
import cn.woodwhales.rbac.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.common.model.vo.RespVO;

import javax.validation.constraints.NotBlank;

/**
 * @author woodwhales on 2021-05-18 16:35
 * @description
 */
@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询角色信息
     * @param param
     * @return
     */
    @GetMapping("/page")
    public PageRespVO<RoleVO> page(@Validated RoleQueryParam param) {
        return roleService.page(param);
    }

    /**
     * 查询角色详情
     * 关联角色权限集合
     * @param roleId
     * @return
     */
    @GetMapping("/detail")
    public RespVO<RoleDetailVO> detail(@Validated @NotBlank Long roleId) {
        return RespVO.resp(roleService.detail(roleId));
    }

    /**
     * 创建角色
     * 可以关联权限集合
     * @param param
     * @return
     */
    @PostMapping("/create")
    public RespVO<Void> create(@Validated @RequestBody RoleCreateParam param) {
        return RespVO.resp(roleService.create(param));
    }

    /**
     * 更新角色
     * 可以关联权限集合
     * @param param
     * @return
     */
    @PostMapping("/update")
    public RespVO<Void> update(@Validated @RequestBody RoleUpdateParam param) {
        return RespVO.resp(roleService.update(param));
    }

}
