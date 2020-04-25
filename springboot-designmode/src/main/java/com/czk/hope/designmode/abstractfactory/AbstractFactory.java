package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:20
 */
//抽象工厂
public abstract class AbstractFactory {
    public abstract RideHand createRideHand();
    public abstract TakeOut createTakeOut();
}
