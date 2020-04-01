package com.czk.hope.designmode.iterator.menu;

import java.util.ArrayList;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/30 15:00
 * lou的煎饼屋
 */
public class PancakeaHouseMenu {
    ArrayList menuItems;

    public PancakeaHouseMenu() {
        menuItems = new ArrayList();

        addIntem("BreakFast", "Pancakes with scrambled aggs", true, 2.99);

        addIntem("BreakFast", "Pancakes with fried aggs", false, 2.99);

        addIntem("Blueberry Pancakes", "Pancakes with fresh blueberries", true, 3.49);

        addIntem("Waffles", "Waffles", true, 3.59);
    }

    public void addIntem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItem() {
        return menuItems;
    }
}
