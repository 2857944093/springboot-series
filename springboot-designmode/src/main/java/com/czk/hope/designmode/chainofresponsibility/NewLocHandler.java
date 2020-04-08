package com.czk.hope.designmode.chainofresponsibility;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 11:19
 */
public class NewLocHandler extends Handler {
    @Override
    public void HandleRequest(int i) {
        if (i < 99) {
            System.out.println("NewLoc 来处理");
        } else {
            successor.HandleRequest(i);
        }
    }
}
