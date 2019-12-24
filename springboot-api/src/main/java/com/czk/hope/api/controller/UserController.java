package com.czk.hope.api.controller;

import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.Users;
import com.czk.hope.util.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:49
 */
@Api(value = "用户")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户")
    @GetMapping("get/user")
    public R getUser(@RequestParam("id") Integer id) {
        return R.ok(userService.queryById(id));
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("del/user")
    public R delUser(@RequestParam("id") Integer id) {
        userService.delById(id);
        return R.ok();
    }
}
