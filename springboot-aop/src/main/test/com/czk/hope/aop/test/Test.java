package com.czk.hope.aop.test;

import com.czk.hope.aop.service.Hello;
import com.czk.hope.aop.service.HelloImpl;

import java.lang.reflect.Proxy;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/20 14:02
 */
public class Test {
    public static void main(String [] args) {
        Hello hello = new HelloImpl();
        Hello o = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), new ProxyHandler(hello));
        o.sayHello();
    }
}
