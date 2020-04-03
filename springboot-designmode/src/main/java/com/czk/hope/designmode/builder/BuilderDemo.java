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

        Product product = director.construct();
    }
}
