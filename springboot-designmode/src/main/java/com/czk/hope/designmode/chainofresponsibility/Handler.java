package com.czk.hope.designmode.chainofresponsibility;

import com.sun.net.httpserver.Authenticator;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 11:04
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void HandleRequest(int i);
}
