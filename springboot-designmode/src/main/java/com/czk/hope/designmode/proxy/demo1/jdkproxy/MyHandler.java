package com.czk.hope.designmode.proxy.demo1.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/3/31 21:06
 */
public class MyHandler implements InvocationHandler {
    Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理对象
     * @param method 被代理对象的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        befoer();
        method.invoke(target);
        after();
        return null;
    }

    public void befoer () {
        System.out.println("begin");
    }

    public void after() {
        System.out.println("over");
    }
}
