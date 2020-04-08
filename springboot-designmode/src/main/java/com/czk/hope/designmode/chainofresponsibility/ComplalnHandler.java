package com.czk.hope.designmode.chainofresponsibility;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 11:19
 */
public class ComplalnHandler extends Handler {
    @Override
    public void HandleRequest(int i) {
        if (i < 80) {
            System.out.println("Complaln 来处理");
        } else {
            successor.HandleRequest(i);
        }
    }
}
