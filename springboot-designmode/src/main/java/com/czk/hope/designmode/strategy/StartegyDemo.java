package com.czk.hope.designmode.strategy;

import com.czk.hope.designmode.strategy.duck.Duck;
import com.czk.hope.designmode.strategy.duck.ModelDuck;
import com.czk.hope.designmode.strategy.fly.FlyNoWay;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 11:13
 * 策略模式测试类
 */
public class StartegyDemo {
    public static void main(String[] args) {
        Duck duck = new ModelDuck();
        duck.performFly();
        //动态改变飞行行为
        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
        duck.performQuack();
    }
}
