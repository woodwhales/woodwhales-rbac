package cn.woodwhales.rbac.web.controller;

import cn.woodwhales.rbac.common.model.param.UserCreateParam;
import cn.woodwhales.rbac.common.model.param.UserQueryParam;
import cn.woodwhales.rbac.common.model.param.UserUpdateParam;
import cn.woodwhales.rbac.common.model.vo.UserDetailVO;
import cn.woodwhales.rbac.common.model.vo.UserVO;
import cn.woodwhales.rbac.service.service.UserService;
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
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询用户信息
     * @param param
     * @return
     */
    @GetMapping("/page")
    public PageRespVO<UserVO> page(@Validated UserQueryParam param) {
        return userService.page(param);
    }

    /**
     * 查询用户详情
     * 关联用户角色集合
     * @param userId
     * @return
     */
    @GetMapping("/detail")
    public RespVO<UserDetailVO> detail(@Validated @NotBlank Long userId) {
        return RespVO.resp(userService.detail(userId));
    }

    /**
     * 创建用户
     * 可以关联角色
     * @param param
     * @return
     */
    @PostMapping("/create")
    public RespVO<Void> create(@Validated @RequestBody UserCreateParam param) {
        return RespVO.resp(userService.create(param));
    }

    /**
     * 更新用户
     * 可以关联角色
     * @param param
     * @return
     */
    @PostMapping("/update")
    public RespVO<Void> update(@Validated @RequestBody UserUpdateParam param) {
        return RespVO.resp(userService.update(param));
    }

}
