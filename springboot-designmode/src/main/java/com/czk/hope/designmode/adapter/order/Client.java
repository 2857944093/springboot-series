package com.czk.hope.designmode.adapter.order;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/4/22 20:25
 */
public class Client{
    public static void main(String[] args) {
        Eleme eleme = new Adapter(new Meituanimpl());
        eleme.elemeOrder();
    }
}