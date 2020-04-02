package com.czk.hope.designmode.composite;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 14:17
 */
public class Waitress {
    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
