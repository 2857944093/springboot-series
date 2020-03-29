package com.czk.hope.designmode.strategy.duck;

import com.czk.hope.designmode.strategy.fly.FlyBehavior;
import com.czk.hope.designmode.strategy.quack.QuackBehavior;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 10:56
 * 鸭子接口
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;

    protected QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("所有鸭子都会游泳");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();
}
