package com.czk.hope.designmode.decorator.coffee;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:20
 */
public class HouseBland extends Beverage {

    public HouseBland() {
        description = "House Bland Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
