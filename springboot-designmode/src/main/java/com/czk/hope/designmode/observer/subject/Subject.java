package com.czk.hope.designmode.observer.subject;

import com.czk.hope.designmode.observer.display.Observer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 14:24
 * 主題，气象
 */
public interface Subject {
    //注册观察者
    void registerObserver(Observer o);

    //删除观察者
    void removerObserver(Observer o);

    //通知观察者
    void notifyObservers();
}
