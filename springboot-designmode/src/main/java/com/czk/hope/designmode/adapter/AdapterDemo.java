package com.czk.hope.designmode.adapter;

import com.czk.hope.designmode.adapter.compute.AdapterCompute;
import com.czk.hope.designmode.adapter.duck.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 15:01
 * 将一个接口转换成客户想要的另一个接口
 */
public class AdapterDemo {
    public static void main(String[] args) {

        AdapterCompute adapterCompute = new AdapterCompute();
        System.out.println(adapterCompute.add(1, 2, 3));

        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck adapterTurkey = new AdapterTurkey(turkey);

        adapterTurkey.quack();
        adapterTurkey.fly();
        duck.quack();
        duck.fly();
    }
}
