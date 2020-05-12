package com.czk.hope.api.service.impl;

import com.czk.hope.entity.model.User;
import com.czk.hope.entity.repository.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        User user = userMapper.selectById(1);
        Assert.assertNotNull(user);
    }

}