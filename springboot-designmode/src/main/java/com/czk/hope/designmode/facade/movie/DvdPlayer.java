package com.czk.hope.designmode.facade.movie;

import org.aspectj.apache.bcel.classfile.SourceFile;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 16:11
 * dvd播放器
 */
public class DvdPlayer {
    public void on() {
        System.out.println("dvd播放器开机");
    }

    public void off() {
        System.out.println("dvd播放器关机");
    }

    public void play(String movie) {
        System.out.println("播放dvd:" + movie);
    }

    public void stop() {
        System.out.println("dvd停止播放");
    }

    public void eject() {
        System.out.println("退出磁盘");
    }
}
