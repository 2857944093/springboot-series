package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:50
 */
public class SmallNutFactory{
    private static SmallNutFactory smallScrewPlant = new SmallNutFactory();

    private SmallNutFactory() {}

    public void print() {
        System.out.println("制作小螺帽");
    }

    public static SmallNutFactory getInstance() {
        return smallScrewPlant;
    }
}
