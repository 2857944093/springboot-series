package com.czk.hope.designmode.mediator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:02
 * 中介者
 */
public interface Mediator {
    void registry(String colleagueName, Colleague colleague);
    void getMessage(int stateChange, String colleagueName);
    void sengMessage();
}
