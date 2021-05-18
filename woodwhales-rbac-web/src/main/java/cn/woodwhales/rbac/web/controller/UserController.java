package cn.woodwhales.rbac.web.controller;

import cn.woodwhales.rbac.common.model.param.UserCreateParam;
import cn.woodwhales.rbac.common.model.param.UserQueryParam;
import cn.woodwhales.rbac.common.model.param.UserUpdateParam;
import cn.woodwhales.rbac.common.model.vo.UserVO;
import cn.woodwhales.rbac.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.common.model.vo.RespVO;

/**
 * @author woodwhales on 2021-05-18 16:35
 * @description
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public PageRespVO<UserVO> page(@Validated UserQueryParam param) {
        return userService.page(param);
    }

    @PostMapping("/create")
    public RespVO<Void> create(@Validated @RequestBody UserCreateParam param) {
        return RespVO.resp(userService.create(param));
    }

    @PostMapping("/update")
    public RespVO<Void> update(@Validated @RequestBody UserUpdateParam param) {
        return RespVO.resp(userService.update(param));
    }

}
