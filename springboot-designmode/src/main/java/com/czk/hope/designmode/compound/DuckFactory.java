package com.czk.hope.designmode.compound;

import com.czk.hope.designmode.compound.duck.DuckCall;
import com.czk.hope.designmode.compound.duck.MallardDuck;
import com.czk.hope.designmode.compound.duck.RedheadDuck;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:50
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RedheadDuck();
    }
}
