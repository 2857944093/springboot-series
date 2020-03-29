package com.czk.hope.designmode.templatemethod.shop;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 17:28
 */
public class Tea extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}
