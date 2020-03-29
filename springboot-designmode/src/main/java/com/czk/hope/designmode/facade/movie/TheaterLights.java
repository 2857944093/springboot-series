package com.czk.hope.designmode.facade.movie;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 16:09
 * 剧院灯光
 */
public class TheaterLights {
    public void dim(int lights) {
        System.out.println("设置剧院灯关:" + lights);
    }

    public void on() {
        System.out.println("剧院灯关关闭");
    }
}
