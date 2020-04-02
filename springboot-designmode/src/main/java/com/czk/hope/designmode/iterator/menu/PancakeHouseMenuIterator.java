package com.czk.hope.designmode.iterator.menu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 10:39
 */
public class PancakeHouseMenuIterator implements Iterator {
    ArrayList<MenuItem> itemMenu;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList itemMenu) {
        this.itemMenu = itemMenu;
    }


    @Override
    public boolean hasNext() {
        if (position >= itemMenu.size() || itemMenu.get(position) == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = itemMenu.get(position);
        position += 1;
        return menuItem;
    }
}
