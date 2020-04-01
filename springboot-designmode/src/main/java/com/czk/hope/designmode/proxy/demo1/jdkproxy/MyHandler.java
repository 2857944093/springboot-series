package com.czk.hope.designmode.proxy.demo1.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/3/31 21:06
 */
public class MyHandler implements MyInvocationHandler {
    Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    public void befoer () {
        System.out.println("begin");
    }

    public void after() {
        System.out.println("over");
    }

    @Override
    public void invoke(Object o, Method me) throws InvocationTargetException, IllegalAccessException {
        befoer();
        me.invoke(target);
        after();
    }
}
