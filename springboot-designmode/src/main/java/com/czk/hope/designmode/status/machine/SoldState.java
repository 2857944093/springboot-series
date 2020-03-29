package com.czk.hope.designmode.status.machine;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:50
 */
public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你购买了糖果");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("不能退钱，你已经拿到糖果了");
    }

    @Override
    public void turnCrank() {
        System.out.println("你已经拿过一次了，请再次投币");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
           gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
