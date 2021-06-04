package cn.woodwhales.rbac.web.controller;

import cn.woodwhales.rbac.common.model.param.PermissionCreateParam;
import cn.woodwhales.rbac.common.model.param.PermissionQueryParam;
import cn.woodwhales.rbac.common.model.param.PermissionUpdateParam;
import cn.woodwhales.rbac.common.model.vo.PermissionVO;
import cn.woodwhales.rbac.service.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.common.model.vo.RespVO;

/**
 * @author woodwhales on 2021-05-18 16:35
 * @description
 */
@RequestMapping("/permission")
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 分页查询权限
     * @param param
     * @return
     */
    @GetMapping("/page")
    public PageRespVO<PermissionVO> page(@Validated PermissionQueryParam param) {
        return permissionService.page(param);
    }

    /**
     * 创建权限
     * @param param
     * @return
     */
    @PostMapping("/create")
    public RespVO<Void> create(@Validated @RequestBody PermissionCreateParam param) {
        return RespVO.resp(permissionService.create(param));
    }

    /**
     * 更新权限
     * @param param
     * @return
     */
    @PostMapping("/update")
    public RespVO<Void> update(@Validated @RequestBody PermissionUpdateParam param) {
        return RespVO.resp(permissionService.update(param));
    }

}
