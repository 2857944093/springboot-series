package com.czk.hope.designmode.mediator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:07
 */
public abstract class Colleague {
    protected Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void sendMessage(int stateChange);

}
