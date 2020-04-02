package com.czk.hope.designmode.composite;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 13:57
 */
public class CompositeDemo {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("a", "this a");
        MenuComponent dinerMenu = new Menu("b", "this b");
        MenuComponent cafeMenu = new Menu("c", "this c");

        MenuComponent allMenu = new Menu("A", "this is all menu");

        allMenu.add(pancakeHouseMenu);
        allMenu.add(dinerMenu);
        allMenu.add(cafeMenu);

        dinerMenu.add(new MenuItem("1", "111", true, 2));
        dinerMenu.add(new MenuItem("2", "222", true, 2));


        Waitress waitress = new Waitress(allMenu);
        waitress.printMenu();
    }
}
