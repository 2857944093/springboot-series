package com.czk.hope.designmode.compound.duck;

import com.czk.hope.designmode.compound.Observer;
import com.czk.hope.designmode.compound.Quackable;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:32
 */
public class RedheadDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

}
