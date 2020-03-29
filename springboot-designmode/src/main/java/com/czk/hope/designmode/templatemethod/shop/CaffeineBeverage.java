package com.czk.hope.designmode.templatemethod.shop;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 17:29
 * 饮料抽象类
 */
public abstract class CaffeineBeverage {

    public final void preparRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public abstract void brew() ;

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public abstract void addCondiments();

    public void boilWater() {
        System.out.println("Boiling water");
    }
}
