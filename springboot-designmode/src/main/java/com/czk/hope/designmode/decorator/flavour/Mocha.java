package com.czk.hope.designmode.decorator.flavour;

import com.czk.hope.designmode.decorator.coffee.Beverage;
import com.czk.hope.designmode.decorator.CondimentDecorator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:26
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20d;
    }
}
