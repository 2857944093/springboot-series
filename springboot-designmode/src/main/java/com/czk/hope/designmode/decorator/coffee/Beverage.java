package com.czk.hope.designmode.decorator.coffee;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/25 15:10
 * 饮料抽象类
 */
public abstract class Beverage {
    String description;

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
