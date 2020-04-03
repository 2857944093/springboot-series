package com.czk.hope.designmode.builder;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 16:56
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getProduct() {
        return product;
    }
}
