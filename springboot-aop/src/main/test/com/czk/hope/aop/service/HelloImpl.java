package com.czk.hope.aop.service;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/20 14:05
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
