package com.czk.hope.designmode.compound;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 13:22
 */
public class Qiackologist implements Observer {
    @Override
    public void update(QuackObserverable duck) {
        System.out.println(duck);
    }
}
