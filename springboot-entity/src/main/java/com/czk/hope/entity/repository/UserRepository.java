package com.czk.hope.entity.repository;


import com.czk.hope.entity.config.BaseRepositoryImpl;
import com.czk.hope.entity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:16
 */
@Repository
public class UserRepository extends BaseRepositoryImpl<Users, Integer> {

    @Autowired
    public UserRepository(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Users.class, entityManager), entityManager);
    }
}
