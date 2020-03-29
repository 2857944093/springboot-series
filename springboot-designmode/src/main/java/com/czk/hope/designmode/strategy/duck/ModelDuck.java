package com.czk.hope.designmode.strategy.duck;

import com.czk.hope.designmode.strategy.fly.FlyWithWings;
import com.czk.hope.designmode.strategy.quack.Quack;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 11:11
 */
public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("i'm a model duck");
    }
}
