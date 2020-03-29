package com.czk.hope.aop.test;

import com.czk.hope.aop.service.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/20 14:02
 * 动态代理
 */
public class ProxyHandler implements InvocationHandler {

    private Hello hello;

    ProxyHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(hello, args);
        after();
        return null;
    }

    public void before() {
        System.out.println("before : ...");
    }

    public void after() {
        System.out.println("after : ...");
    }
}
