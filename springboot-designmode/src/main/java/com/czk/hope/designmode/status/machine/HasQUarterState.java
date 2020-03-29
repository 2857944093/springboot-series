package com.czk.hope.designmode.status.machine;

import java.util.Random;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:50
 */
public class HasQUarterState implements State {
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    public HasQUarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你已投了25分钱");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("钱退给你了");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            System.out.println("成功拿到糖果");
            gumballMachine.setState(gumballMachine.getSoldSate());
        }

    }

    @Override
    public void dispense() {
        System.out.println("拿不到糖果");
    }
}
