package com.czk.hope.designmode.strategy.fly;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 10:59
 * 真的会飞的鸭子
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("i'm flying");
    }
}
