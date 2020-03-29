package com.czk.hope.designmode.templatemethod.shop;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 17:22
 */
public class Coffe extends CaffeineBeverage {


    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
