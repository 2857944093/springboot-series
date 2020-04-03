package com.czk.hope.designmode.builder;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 16:57
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        System.out.println("A");
    }

    @Override
    public void buildPartB() {
        System.out.println("B");
    }

    @Override
    public void buildPartC() {
        System.out.println("C");
    }
}
