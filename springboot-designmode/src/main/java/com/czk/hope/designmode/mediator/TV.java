package com.czk.hope.designmode.mediator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:13
 */
public class TV extends Colleague {

    public TV(Mediator mediator, String name){
        super(mediator, name);

        mediator.registry(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void openTV() {
        System.out.println("打开电视");
    }

    public void closeTV() {
        System.out.println("关闭电视");
    }
}
