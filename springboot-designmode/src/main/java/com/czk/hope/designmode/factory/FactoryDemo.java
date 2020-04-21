package com.czk.hope.designmode.factory;

import com.czk.hope.designmode.factory.pizza.Product;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 17:12
 * 工厂模式
 */
public class FactoryDemo {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        Product pizza = new PizzaStore(factory).orderPizza("clam");
        pizza.print();
    }
}
