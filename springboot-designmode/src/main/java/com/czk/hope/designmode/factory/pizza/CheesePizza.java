package com.czk.hope.designmode.factory.pizza;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 14:50
 */
public class CheesePizza implements Product {
    @Override
    public void print() {
        System.out.println("cheese");
    }
}
