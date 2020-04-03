package com.czk.hope.designmode.compound;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:55
 * 迭代器模式
 */
public class Flock implements Quackable {

    ArrayList duck = new ArrayList();

    public void add(Quackable duck) {
        this.duck.add(duck);
    }

    @Override
    public void quack() {
        Iterator iterator = duck.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }
}
