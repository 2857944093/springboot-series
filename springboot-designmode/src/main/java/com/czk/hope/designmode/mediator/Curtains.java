package com.czk.hope.designmode.mediator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:13
 */
public class Curtains extends Colleague {


    public Curtains(Mediator mediator, String name){
        super(mediator, name);

        mediator.registry(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void openCurtains() {
        System.out.println("打开窗帘");
    }
    public void closeCurtains() {
        System.out.println("关闭窗帘");
    }


}

