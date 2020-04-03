package com.czk.hope.designmode.bridge;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 15:02
 */
public class RCA implements TV {

    @Override
    public void on() {
        System.out.println("rca on");
    }

    @Override
    public void off() {
        System.out.println("rca off");
    }

    @Override
    public void tuneChannel() {
        System.out.println("rca CCTV");
    }
}
