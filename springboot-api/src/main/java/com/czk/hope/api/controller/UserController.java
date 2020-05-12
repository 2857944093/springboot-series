package com.czk.hope.api.controller;

import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.User;
import com.czk.hope.util.SendSmsUtils;
import com.czk.hope.util.enums.ResultEnum;
import com.czk.hope.util.redis.RedisUtils;
import com.czk.hope.util.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:49
 */
@Api(value = "用户")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SendSmsUtils sendSmsUtils;

    @ApiOperation(value = "获取短信验证码")
    @PostMapping(value = "/getOtpCode")
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

    @ApiOperation(value = "注册用户", notes = "注册用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/register")
    public R register(@RequestParam String phone, @RequestParam String otpCode) {
        String code = redisUtils.getMap(phone);
        if (StringUtils.isBlank(code) || !code.equals(otpCode)) {
            return R.error(ResultEnum.OTP_ERROR);
        }
        User users = new User();
        users.setName(phone);
        users.setAge(18);
        users.setEmail("123@abc.com");
        userService.save(users);
        return R.ok();
    }

    @ApiOperation(value = "获取用户")
    @GetMapping(value = "/get")
    public R getUser(@RequestParam("id") Integer id) {
        return R.ok(userService.getById(id));
    }

    @ApiOperation(value = "删除用户")
    @PostMapping(value = "/del")
    public R delUser(@RequestParam("id") Integer id) {
        userService.removeById(id);
        return R.ok();
    }
}
