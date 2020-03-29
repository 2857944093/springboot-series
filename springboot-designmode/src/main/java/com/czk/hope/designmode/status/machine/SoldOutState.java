package com.czk.hope.designmode.status.machine;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:48
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("糖果已经卖完了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("不能退钱，糖果都没有了");
    }

    @Override
    public void turnCrank() {
        System.out.println("已经没有糖果了");
        gumballMachine.refill(10);
    }

    @Override
    public void dispense() {
        System.out.println("拿不到糖果");
    }
}
