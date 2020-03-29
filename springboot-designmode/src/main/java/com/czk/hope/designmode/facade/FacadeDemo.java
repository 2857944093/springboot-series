package com.czk.hope.designmode.facade;

import com.czk.hope.designmode.facade.movie.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 15:36
 * 外观模式
 */
public class FacadeDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amp, dvd, projector, lights, screen, popper);
        homeTheaterFacade.watchMovie("奥特曼");

        homeTheaterFacade.endMovie();
    }
}
