package com.czk.hope.designmode.iterator.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 10:44
 * 菜单服务人员
 */
public class Waitress {
    protected Menu pancakeHouseMenu;
    protected Menu dinerMenu;
    protected List menus;

    public Waitress(List menus) {
        this.menus = menus;
    }

    public void printMenu() {
        /*Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        printMenu(pancakeIterator);
        printMenu(dinerIterator);*/
        Iterator iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = (Menu) iterator.next();
            printMenu(menu.createIterator());
        }
    }

    public void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getDescription());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.isVegetarian());
        }
        System.out.println("--------------------------");
    }
}
