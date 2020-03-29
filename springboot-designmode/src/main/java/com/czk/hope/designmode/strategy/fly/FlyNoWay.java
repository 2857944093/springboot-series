package com.czk.hope.designmode.strategy.fly;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 11:00
 * 不会飞的鸭子
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("i can't fly");
    }
}
