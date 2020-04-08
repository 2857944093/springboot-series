package com.czk.hope.designmode.interpreter.demo;

import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:52
 */
public class VarExpresstion extends AbstractExpresstion {
    private String key;

    public VarExpresstion(String _key) {
        this.key = _key;
    }

    @Override
    public Float interpreter(HashMap<String, Float> var) {
        return var.get(this.key);
    }
}
