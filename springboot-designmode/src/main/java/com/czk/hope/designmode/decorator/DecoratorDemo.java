package com.czk.hope.designmode.decorator;

import com.czk.hope.designmode.decorator.coffee.Beverage;
import com.czk.hope.designmode.decorator.coffee.Espresso;
import com.czk.hope.designmode.decorator.flavour.Mocha;
import com.czk.hope.designmode.decorator.flavour.Soy;
/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:33
 * 装饰器模式
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+beverage.cost());

        beverage = new Mocha(beverage);
        beverage = new Soy(beverage);

        System.out.println(beverage.getDescription()+beverage.cost());
    }
}
