package com.czk.hope.designmode.chainofresponsibility;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 11:18
 */
public class FanHandler extends Handler {
    @Override
    public void HandleRequest(int i) {
        if (i < 60) {
            System.out.println("Fan 来处理");
        } else {
            successor.HandleRequest(i);
        }
    }
}
