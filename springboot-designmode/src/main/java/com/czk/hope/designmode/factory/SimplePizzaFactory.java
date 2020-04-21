package com.czk.hope.designmode.factory;

import com.czk.hope.designmode.factory.pizza.CheesePizza;
import com.czk.hope.designmode.factory.pizza.ClamPizza;
import com.czk.hope.designmode.factory.pizza.Product;
import com.czk.hope.designmode.factory.pizza.VeggiePizza;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 14:49
 * 披萨工厂
 */
public class SimplePizzaFactory {
    public Product createPizza(String type) {
        Product pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
