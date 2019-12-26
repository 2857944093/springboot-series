package com.czk.hope.api.service.impl;

import com.czk.hope.aop.annotation.DataSource;
import com.czk.hope.aop.annotation.RedisCleanCache;
import com.czk.hope.aop.annotation.RedisJoinCache;
import com.czk.hope.api.service.UserService;
import com.czk.hope.entity.model.Users;
import com.czk.hope.entity.repository.UserRepository;
import com.czk.hope.util.jpa.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:53
 */
@Service("userService")
public class UserServiceImpl extends CrudService<UserRepository, Users, Integer> implements UserService{

    @RedisJoinCache(type = Users.class)
    @DataSource(name = "db1")
    @Override
    public Users queryById(Integer id) {
        return getById(id);
    }

    @RedisCleanCache(type = Users.class, name = "queryById")
    @Override
    public void delById(Integer id) {
        deleteById(id);
    }



}
