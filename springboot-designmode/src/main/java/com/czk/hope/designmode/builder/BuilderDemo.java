package com.czk.hope.designmode.builder;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 15:19
 * 建筑者模式
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        //不同的实现方法，可以构造不同的表现
        Product product = director.construct();
        System.out.println();
        product = director.construct2();
    }
}
