package com.czk.hope.api.controller;

import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.Users;
import com.czk.hope.util.SendSmsUtils;
import com.czk.hope.util.enums.ResultEnum;
import com.czk.hope.util.redis.RedisUtils;
import com.czk.hope.util.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:49
 */
@Api(value = "用户")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SendSmsUtils sendSmsUtils;

    @ApiOperation(value = "获取短信验证码")
    @PostMapping(value = "getcode")
    public R getCode(@RequestParam String phone) {

        String code = sendSmsUtils.getCode();

        String otpcode = redisUtils.getMap(phone);

        if (!StringUtils.isBlank(otpcode)) {
            return R.error(ResultEnum.OTPCODE_GET_FREQUENTLY);
        }

        sendSmsUtils.sendSms(phone, code);

        redisUtils.setMap(phone, code);

        redisUtils.expire(phone);

        return R.ok(code);
    }

    @ApiOperation(value = "注册用户")
    @PostMapping(value = "register/user")
    public R register(@RequestParam String phone, @RequestParam String otpCode) {
        String code = redisUtils.getMap(phone);
        if (StringUtils.isBlank(code) || !code.equals(otpCode)) {
            return R.error(ResultEnum.OTP_ERROR);
        }
        Users users = new Users();
        users.setName(phone);
        users.setAge(18);
        users.setSex("男");
        userService.saveUser(users);
        return R.ok();
    }

    @ApiOperation(value = "获取用户")
    @GetMapping(value = "get/user")
    public R getUser(@RequestParam("id") Integer id) {
        return R.ok(userService.queryById(id));
    }

    @ApiOperation(value = "删除用户")
    @PostMapping(value = "del/user")
    public R delUser(@RequestParam("id") Integer id) {
        userService.delById(id);
        return R.ok();
    }
}
