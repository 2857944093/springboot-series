package com.czk.hope.designmode.chainofresponsibility;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 11:02
 * 责任链模式
 */
public class ChainDemo {
    public static void main(String[] args) {
        Handler sparn = new SparnHandler();
        Handler fan = new FanHandler();
        Handler complaln = new ComplalnHandler();
        Handler newLoc = new NewLocHandler();

        sparn.setSuccessor(fan);
        fan.setSuccessor(complaln);
        complaln.setSuccessor(newLoc);

        sparn.HandleRequest(50);
    }
}

