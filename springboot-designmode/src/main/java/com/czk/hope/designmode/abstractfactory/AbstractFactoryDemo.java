package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:57
 * 抽象工厂
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractPlant bigPlant = new BigPlantFactory();
        bigPlant.createPizza();
        AbstractPlant smallPlant = new SmallPlantFactory();
        smallPlant.createPizza();
    }
}
