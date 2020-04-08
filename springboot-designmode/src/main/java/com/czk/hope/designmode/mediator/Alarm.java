package com.czk.hope.designmode.mediator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:12
 */
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name){
        super(mediator, name);

        mediator.registry(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }
}
