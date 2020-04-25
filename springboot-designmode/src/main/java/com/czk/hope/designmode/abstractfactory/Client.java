package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:39
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory elemeFactory = new ElemeFactory();
        RideHand rideHand = elemeFactory.createRideHand();
        TakeOut takeOut = elemeFactory.createTakeOut();
        rideHand.show();
        takeOut.show();
    }
}
