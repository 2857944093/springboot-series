package com.czk.hope.designmode.decorator.flavour;

import com.czk.hope.designmode.decorator.coffee.Beverage;
import com.czk.hope.designmode.decorator.CondimentDecorator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:28
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}
