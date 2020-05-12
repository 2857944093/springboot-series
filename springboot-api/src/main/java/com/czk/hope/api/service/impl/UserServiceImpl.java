package com.czk.hope.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czk.hope.aop.annotation.RedisCleanCache;
import com.czk.hope.aop.annotation.RedisJoinCache;
import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.User;
import com.czk.hope.entity.repository.UserMapper;
import com.czk.hope.util.jpa.CrudService;
import org.springframework.stereotype.Service;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:53
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
