package com.czk.hope.designmode.adapter.duck;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 14:59
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("i can fly");
    }
}
