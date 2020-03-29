package com.czk.hope.designmode.decorator;

import com.czk.hope.designmode.decorator.coffee.Beverage;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:22
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
