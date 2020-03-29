package com.czk.hope.designmode.status.machine;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/27 13:45
 * 状态接口
 */
public interface State {
    //投钱方法
    void insertQuarter();
    //退钱方法
    void ejectQuarter();
    //摇杆方法
    void turnCrank();
    //发放糖果
    void dispense();
}
