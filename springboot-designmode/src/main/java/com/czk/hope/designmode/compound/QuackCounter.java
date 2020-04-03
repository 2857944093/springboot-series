package com.czk.hope.designmode.compound;

import java.util.Observer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:40
 * 装饰器
 */
public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }

}
