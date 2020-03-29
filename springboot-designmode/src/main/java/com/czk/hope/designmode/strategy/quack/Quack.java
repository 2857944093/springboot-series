package com.czk.hope.designmode.strategy.quack;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 11:03
 * 真会叫的鸭子
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack");
    }
}
