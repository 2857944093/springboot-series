package com.czk.hope.designmode.compound;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 11:03
 * 观察者模式
 */
public interface QuackObserverable {
    public void registerObserver(Observer observer);
    public void notiyObservers();
}
