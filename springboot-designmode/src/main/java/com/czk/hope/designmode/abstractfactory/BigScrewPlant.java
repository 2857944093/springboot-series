package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:36
 */
public class BigScrewPlant{
    private static BigScrewPlant bigScrewPlant = new BigScrewPlant();

    private BigScrewPlant () {}

    void print() {
        System.out.println("制作大螺丝");
    }

    public static BigScrewPlant getInstance(){
        return bigScrewPlant;
    }
}

