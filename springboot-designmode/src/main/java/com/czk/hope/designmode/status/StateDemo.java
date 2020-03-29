package com.czk.hope.designmode.status;

import com.czk.hope.designmode.status.machine.GumballMachine;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:39
 * 状态模式
 */
public class StateDemo {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(1);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
