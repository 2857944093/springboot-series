package com.czk.hope.designmode.status.machine;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:19
 * 糖果机
 */
public class GumballMachine {

    //售罄状态
    State soldOutState ;
    //没有25分时的状态
    State noQuarterState;
    //有25分时的状态
    State hasQuarter;
    //卖出糖果状态
    State soldSate;
    //十次中一次
    State winnerState;

    State state = soldOutState;
    int count = 0;


    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarter = new HasQUarterState(this);
        soldSate = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    //投分钱方法
    public void insertQuarter() {
        state.insertQuarter();
    }

    //退钱方法
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    //摇杆方法
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    //发放糖果
    public void dispense() {
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    //填方糖果
    void refill(int count) {
        System.out.println("正在存放糖果");
        this.count = count;
        state = noQuarterState;
    }

    //出售糖果
    void releaseBall() {
        System.out.println("售出一个糖果");
        if (count != 0) {
            count = count - 1;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public State getHasQuarter() {
        return hasQuarter;
    }

    public void setHasQuarter(State hasQuarter) {
        this.hasQuarter = hasQuarter;
    }

    public State getSoldSate() {
        return soldSate;
    }

    public void setSoldSate(State soldSate) {
        this.soldSate = soldSate;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }
}
