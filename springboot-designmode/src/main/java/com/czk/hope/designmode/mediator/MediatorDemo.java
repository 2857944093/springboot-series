package com.czk.hope.designmode.mediator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 16:10
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague alarm = new Alarm(mediator, "Alarm");
        Colleague curtains = new Curtains(mediator, "Curtains");
        Colleague tv = new TV(mediator, "TV");

        alarm.sendMessage(0);
        alarm.sendMessage(1);

    }
}
