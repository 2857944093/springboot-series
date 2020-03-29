package com.czk.hope.designmode.decorator.coffee;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:24
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
