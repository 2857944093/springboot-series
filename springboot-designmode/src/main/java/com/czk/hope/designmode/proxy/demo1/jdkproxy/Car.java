package com.czk.hope.designmode.proxy.demo1.jdkproxy;

import java.lang.reflect.InvocationHandler;

public class Car implements Move {
    @Override
    public void move() {
        System.out.println("move");
    }
}
