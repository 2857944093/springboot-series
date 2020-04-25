package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:43
 */
//美团工厂
public class MeituanFactory extends AbstractFactory {
    @Override
    public RideHand createRideHand() {
        return new MeituanRideHand();
    }

    @Override
    public TakeOut createTakeOut() {
        return new MeituanTakeOut();
    }
}
