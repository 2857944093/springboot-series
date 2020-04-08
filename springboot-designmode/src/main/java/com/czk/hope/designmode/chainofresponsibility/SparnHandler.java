package com.czk.hope.designmode.chainofresponsibility;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 11:07
 */
public class SparnHandler extends Handler {

    @Override
    public void HandleRequest(int i) {
        if (i < 30) {
            System.out.println("Sparn 来处理");
        } else {
            successor.HandleRequest(i);
        }
    }


}
