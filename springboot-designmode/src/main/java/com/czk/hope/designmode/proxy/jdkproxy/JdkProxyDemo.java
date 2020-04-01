package com.czk.hope.designmode.proxy.jdkproxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/3/31 20:11
 * jdk动态代理
 */
public class JdkProxyDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        /*Car car = new Car();
        Move move = (Move) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), new MyHandler(car));
        move.move();*/
        Car car = new Car();
        MyInvocationHandler h = new MyHandler(car);
        Move move = (Move) MyProxy.newProxyInstance(Move.class, h);
        move.move();
    }
}
