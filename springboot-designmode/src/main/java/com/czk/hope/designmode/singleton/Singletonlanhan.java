package com.czk.hope.designmode.singleton;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 16:36
 * 懒汉式加载，线程不安全，加载块，第一次获取对象慢
 */
public class Singletonlanhan {

    //volatile 确保当instance变量被初始化成Singletonlanhan实例时，多个线程正确的处理instance变量
    private volatile static Singletonlanhan instance;

    private Singletonlanhan() {}

    //双重检查加锁，只有第一次才会彻底执行以下代码块
    public static Singletonlanhan getInstance() {
        if (instance == null) {
            synchronized (Singletonlanhan.class) {
                if (instance == null) {
                    instance = new Singletonlanhan();
                }
            }
        }
        return instance;
    }
}
