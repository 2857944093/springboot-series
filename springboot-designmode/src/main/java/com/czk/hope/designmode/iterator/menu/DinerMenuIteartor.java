package com.czk.hope.designmode.iterator.menu;


import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 10:35
 */
public class DinerMenuIteartor implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIteartor(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position += 1;
        return menuItem;
    }
}
