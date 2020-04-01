package com.czk.hope.designmode.proxy.demo1.jdkproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/1 17:16
 */
public interface MyInvocationHandler {
    void invoke(Object o, Method me) throws InvocationTargetException, IllegalAccessException;
}
