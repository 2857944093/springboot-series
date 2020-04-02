package com.czk.hope.designmode.factory;

import com.czk.hope.designmode.factory.pizza.Pizza;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 14:53
 */
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = factory.createPizza(type);

        return pizza;
    }
}
