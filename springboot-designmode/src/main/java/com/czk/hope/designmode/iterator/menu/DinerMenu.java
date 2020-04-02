package com.czk.hope.designmode.iterator.menu;

import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 10:09
 */
public class DinerMenu implements Menu{
    static final int MAX_ITEMS = 6;
    int numberOfitems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BlT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);

        addItem("BlT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);

        addItem("Soup of the day", "Soup of the day, with lettuce & tomato on whole wheat", false, 3.29);

        addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfitems >= MAX_ITEMS) {
            System.out.println("Sorry, menu is full! Can't add itme to menu");
        } else {
            menuItems[numberOfitems] = menuItem;
            numberOfitems = numberOfitems + 1;
        }
    }

    public Iterator createIterator() {
        return new DinerMenuIteartor(menuItems);
    }
}
