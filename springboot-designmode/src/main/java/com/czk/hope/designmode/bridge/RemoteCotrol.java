package com.czk.hope.designmode.bridge;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 14:57
 */
public abstract class RemoteCotrol {

    private TV tv;

    public RemoteCotrol(TV tv) {
        this.tv = tv;
    }

    public TV getTv() {
        return tv;
    }

    public abstract void on();
    public abstract void off();
    public abstract void setChannel();


}
