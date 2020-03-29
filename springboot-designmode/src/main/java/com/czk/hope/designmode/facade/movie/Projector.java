package com.czk.hope.designmode.facade.movie;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 16:15
 * 投影仪
 */
public class Projector {
    public void on() {
        System.out.println("投影仪开机");
    }

    public void off() {
        System.out.println("投影仪关机");
    }

    public void wideScreenMode() {
        System.out.println("宽屏方式");
    }
}

