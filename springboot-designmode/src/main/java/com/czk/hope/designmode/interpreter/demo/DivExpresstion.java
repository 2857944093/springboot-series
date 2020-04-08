package com.czk.hope.designmode.interpreter.demo;

import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:59
 */
public class DivExpresstion extends SymbolExpresstion {
    public DivExpresstion(AbstractExpresstion left, AbstractExpresstion right){
        super(left,right);
    }

    @Override
    public Float interpreter(HashMap<String, Float> var) {
        return super.left.interpreter(var) / super.right.interpreter(var);
    }
}
