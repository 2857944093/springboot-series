package com.czk.hope.designmode.factory;

import com.czk.hope.designmode.factory.pizza.Product;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 14:53
 */
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Product orderPizza(String type) {
        return factory.createPizza(type);
    }
}
