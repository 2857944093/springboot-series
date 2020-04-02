package com.czk.hope.designmode.iterator;

import com.czk.hope.designmode.iterator.menu.DinerMenu;
import com.czk.hope.designmode.iterator.menu.PancakeHouseMenu;
import com.czk.hope.designmode.iterator.menu.Waitress;

import java.util.Arrays;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 10:31
 * 迭代器模式
 */
public class IteratorDemo {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(Arrays.asList(pancakeHouseMenu, dinerMenu));

        waitress.printMenu();
    }
}
