package com.czk.hope.designmode.command.manufacturer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 13:41
 * 车库门
 */
public class GarageDoor {
    public void up() {
        System.out.println("向上");
    }
    public void down() {
        System.out.println("向下");
    }
    public void stop() {
        System.out.println("停止");
    }
    public void ligthOn() {
        System.out.println("关灯");
    }
    public void ligthOff() {
        System.out.println("开灯");
    }
}

