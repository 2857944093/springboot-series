package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:33
 */
//饿了么外卖
public class ElemeTackout implements TakeOut {

    @Override
    public TakeOut takeOut() {
        return new ElemeTackout();
    }

    @Override
    public void show() {
        System.out.println("饿了么外卖");
    }
}
