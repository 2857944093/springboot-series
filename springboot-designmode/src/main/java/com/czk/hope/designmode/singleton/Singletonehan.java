package com.czk.hope.designmode.singleton;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 16:33
 * 饿汉式加载，线程安全，加载慢，获取对象块
 */

public class Singletonehan {
    private static Singletonehan instance = new Singletonehan();

    private Singletonehan() {}

    public static Singletonehan getInstance() {
        return instance;
    }
}
