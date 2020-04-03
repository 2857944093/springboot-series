package com.czk.hope.designmode.compound;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 11:06
 */
public class Observable implements QuackObserverable {

    ArrayList observers = new ArrayList();
    QuackObserverable duck;

    public Observable(QuackObserverable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notiyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = (Observer) iterator.next();
            observer.update(duck);
        }
    }
}
