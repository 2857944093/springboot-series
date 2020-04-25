package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:44
 */
//饿了么工厂
public class ElemeFactory extends AbstractFactory {
    @Override
    public RideHand createRideHand() {
        return new ElemeRideHand();
    }

    @Override
    public TakeOut createTakeOut() {
        return new ElemeTackout();
    }
}
