package com.czk.hope.designmode.bridge;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 15:06
 */
public class ConsreteRemode extends RemoteCotrol {

    public ConsreteRemode(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        getTv().on();
    }

    @Override
    public void off() {
        getTv().off();
    }

    @Override
    public void setChannel() {
        getTv().tuneChannel();
    }
}
