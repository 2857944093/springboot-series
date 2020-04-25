package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:28
 */
//美团骑手
public class MeituanRideHand implements RideHand {

    @Override
    public RideHand rideHand() {
        return new MeituanRideHand();
    }

    @Override
    public void show() {
        System.out.println("美团骑手");
    }
}
