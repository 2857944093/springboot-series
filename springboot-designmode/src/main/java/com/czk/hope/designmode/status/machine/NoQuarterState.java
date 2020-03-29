package com.czk.hope.designmode.status.machine;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:50
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        gumballMachine.setState(gumballMachine.getHasQuarter());
        System.out.println("没有25分钱，已接收25分钱");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("不能退钱，你没有25分钱可退");
    }

    @Override
    public void turnCrank() {
        System.out.println("需要先投入25分钱");
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果");
    }
}
