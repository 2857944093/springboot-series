package com.czk.hope.designmode.iterator.menu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 10:13
 */
public class PancakeHouseMenu implements Menu{
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled aggs, and toast", true, 2.99);

        addItem("Regular Pancake Breakfast", "Pancakes with scrambled aggs, sausage", false, 2.99);

        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);

        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
