package com.czk.hope.designmode.decorator.flavour;

import com.czk.hope.designmode.decorator.coffee.Beverage;
import com.czk.hope.designmode.decorator.CondimentDecorator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:29
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.9;
    }
}
