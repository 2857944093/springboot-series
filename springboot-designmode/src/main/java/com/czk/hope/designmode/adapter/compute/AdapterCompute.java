package com.czk.hope.designmode.adapter.compute;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/26 14:52
 * 适配器，转换成客户期望的能计算三位数的和的接口
 */
public class AdapterCompute extends Compute{

    public double add(int a, int b, int c){
        return add(a, b) + c;
    }

}
