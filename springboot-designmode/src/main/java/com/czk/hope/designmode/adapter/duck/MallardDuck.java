package com.czk.hope.designmode.adapter.duck;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 14:57
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quacj");
    }

    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
