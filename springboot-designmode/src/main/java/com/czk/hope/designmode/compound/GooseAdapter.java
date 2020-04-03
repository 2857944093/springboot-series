package com.czk.hope.designmode.compound;

import com.czk.hope.designmode.compound.goose.Goose;

import java.util.Observer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:37
 * 适配器
 */
public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

}
