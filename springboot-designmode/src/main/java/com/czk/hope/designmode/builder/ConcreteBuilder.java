package com.czk.hope.designmode.builder;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 16:57
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        System.out.print("A");
    }

    @Override
    public void buildPartB() {
        System.out.print("B");
    }

    @Override
    public void buildPartC() {
        System.out.print("C");
    }
}
