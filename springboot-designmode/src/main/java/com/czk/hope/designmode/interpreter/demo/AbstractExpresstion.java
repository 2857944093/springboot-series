package com.czk.hope.designmode.interpreter.demo;

import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:50
 */
public abstract class AbstractExpresstion extends Object{
    public abstract Float interpreter(HashMap<String,Float> var);
}
