package com.czk.hope.designmode.compound;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:48
 * 抽象工厂
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
