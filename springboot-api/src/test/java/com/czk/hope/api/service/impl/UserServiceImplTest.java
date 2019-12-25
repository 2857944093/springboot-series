package com.czk.hope.api.service.impl;

import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.Users;
import com.czk.hope.entity.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void queryById() {
        Users users = userService.queryById(1);
        System.out.println(users.toString());
    }

    @Test
    public void queryTableAll() {
        List<Map<String, String>> table = userRepository.findTableAll();
        table.forEach(e -> {
            e.forEach((k, v) -> {
                System.out.println(k + ":" + v);
            });
        });
    }

    @Test
    public void queryTable() {
        List<Map<String, String>> test1 = userRepository.findTableByTableName("test1");
        test1.forEach(e -> {
            e.forEach((k, v) -> {
                System.out.println(k + ":" + v);
            });
        });
    }

}