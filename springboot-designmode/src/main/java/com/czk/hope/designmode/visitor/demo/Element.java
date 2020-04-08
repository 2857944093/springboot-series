package com.czk.hope.designmode.visitor.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:28
 */
public abstract class Element {
    abstract public void accept(Visitor visitor);
}
