package com.czk.hope.designmode.adapter.order;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/4/22 20:24
 */
public class Adapter implements Eleme{
    Meituan meituan;

    public Adapter (Meituan meituan ) {
        this.meituan = meituan;
    }
    //在饿了么接美团的订单
    public void elemeOrder(){
        meituan.meituanOrder();
    }
}
