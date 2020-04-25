package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:30
 */
//饿了么骑手
public class ElemeRideHand implements RideHand{

    @Override
    public RideHand rideHand() {
        return new ElemeRideHand();
    }

    @Override
    public void show() {
        System.out.println("饿了么骑手");
    }
}
