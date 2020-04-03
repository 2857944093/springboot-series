package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:35
 */
public class BigNutPlant{
    private static BigNutPlant bigNutPlant = new BigNutPlant();

    private BigNutPlant() {}

    void print() {
        System.out.println("制作大螺帽");
    }

    public static BigNutPlant getInstance() {
        return bigNutPlant;
    }
}
