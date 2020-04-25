package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/22 15:32
 */
//美团外卖
public class MeituanTakeOut implements TakeOut{

    @Override
    public TakeOut takeOut() {
        return new MeituanTakeOut();
    }

    @Override
    public void show() {
        System.out.println("美团外卖");
    }
}
