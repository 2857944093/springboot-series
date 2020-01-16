package com.czk.hope.api.service;

import com.czk.hope.aop.annotation.DataSource;
import com.czk.hope.entity.model.Users;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:50
 */
public interface UserService {

    Users queryById(Integer id);

    void delById(Integer id);

    void saveUser(Users user);
}
