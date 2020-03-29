package com.czk.hope.designmode.adapter.duck;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 14:59
 * 火鸡适配器
 */
public class AdapterTurkey implements Duck{

    Turkey turkey;

    public AdapterTurkey(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
