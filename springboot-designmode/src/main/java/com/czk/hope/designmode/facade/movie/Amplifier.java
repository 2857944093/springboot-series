package com.czk.hope.designmode.facade.movie;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 16:02
 * 扩音器
 */
public class Amplifier {
    public void on() {
        System.out.println("开启扩音器");
    }

    public void off() {
        System.out.println("关闭扩音器");
    }

    public void setDvd(){
        System.out.println("设置音频");
    }

    public void setSurroundSound() {
        System.out.println("设置环绕立体音");
    }

    public void serVolume(int volume) {
        System.out.println("调节音量为" + volume);
    }

}
