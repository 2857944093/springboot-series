package com.czk.hope.designmode.compound.duck;

import com.czk.hope.designmode.compound.Observable;
import com.czk.hope.designmode.compound.Observer;
import com.czk.hope.designmode.compound.Quackable;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 10:31
 */
public class MallardDuck implements Quackable {

    Observable observable;

//    public MallardDuck(Observable observable) {
//        this.observable = observable;
//    }

    @Override
    public void quack() {
        System.out.println("Quack");
    }

//    @Override
//    public void registerObserver(Observer observer) {
//        observable.registerObserver(observer);
//    }
//
//    @Override
//    public void notiyObservers() {
//        observable.notiyObservers();
//    }
}
