package com.czk.hope.designmode.abstractfactory;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/2 15:51
 */
public class SmallScrewPlant {
    private static SmallScrewPlant smallScrewPlant = new SmallScrewPlant();

    private SmallScrewPlant() {}

    public void print() {
        System.out.println("制作小螺丝");
    }

    public static SmallScrewPlant getInstance() {
        return smallScrewPlant;
    }
}
