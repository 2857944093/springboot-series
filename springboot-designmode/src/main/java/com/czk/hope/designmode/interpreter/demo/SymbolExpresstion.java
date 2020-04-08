package com.czk.hope.designmode.interpreter.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:54
 */
public abstract class SymbolExpresstion extends AbstractExpresstion {

    protected AbstractExpresstion left;
    protected AbstractExpresstion right;

    public SymbolExpresstion(AbstractExpresstion left, AbstractExpresstion right) {
        this.left = left;
        this.right = right;
    }
}
