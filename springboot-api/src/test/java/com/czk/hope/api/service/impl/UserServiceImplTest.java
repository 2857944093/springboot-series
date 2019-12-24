package com.czk.hope.api.service.impl;

import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.Users;
import com.czk.hope.entity.repository.UserRepository;
import com.czk.hope.util.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @Test
    public void test() {
        Users one = userRepository.getOne(1);
        System.out.println(one.toString());
    }

    @Test
    public void queryById() {
        Users users = userService.queryById(1);
        System.out.println(users.toString());
    }

}