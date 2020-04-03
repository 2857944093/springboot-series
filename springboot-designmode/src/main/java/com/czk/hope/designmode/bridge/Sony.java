package com.czk.hope.designmode.bridge;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 15:04
 */
public class Sony implements TV {
    @Override
    public void on() {
        System.out.println("sony on");
    }

    @Override
    public void off() {
        System.out.println("sony off");
    }

    @Override
    public void tuneChannel() {
        System.out.println("sony cctv");
    }
}
