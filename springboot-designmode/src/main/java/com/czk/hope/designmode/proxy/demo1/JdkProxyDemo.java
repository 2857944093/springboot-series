package com.czk.hope.designmode.proxy.demo1;


import com.czk.hope.designmode.proxy.demo1.jdkproxy.Car;
import com.czk.hope.designmode.proxy.demo1.jdkproxy.Move;
import com.czk.hope.designmode.proxy.demo1.jdkproxy.MyHandler;
import com.czk.hope.designmode.proxy.demo1.jdkproxy.MyProxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/3/31 20:11
 * jdk动态代理
 */
public class JdkProxyDemo {
    public static void main(String[] args) throws IOException {
        /*Car car = new Car();
        Move move = (Move) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), new MyHandler(car));
        move.move();*/
        MyProxy.newProxyInstance();
    }
}
