package com.czk.hope.designmode.compound.duck;

import com.czk.hope.designmode.compound.Quackable;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:33
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
