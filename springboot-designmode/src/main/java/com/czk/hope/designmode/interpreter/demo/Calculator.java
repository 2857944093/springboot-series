package com.czk.hope.designmode.interpreter.demo;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 16:20
 * 参考逆波兰表达式
 */
public class Calculator {
    //定义表达式
    private AbstractExpresstion expresstion;

    public Calculator(String expStr) {
        //定义运算顺序
        Stack<AbstractExpresstion> stack = new Stack<>();
        System.out.println(stack);
        //表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();

        AbstractExpresstion left = null;
        AbstractExpresstion right = null;
        for(int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpresstion(String.valueOf(charArray[++i]));
                    stack.push(new AddExpresstion(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpresstion(String.valueOf(charArray[++i]));
                    stack.push(new SubExpresstion(left, right));
                    break;
                case '*':
                    left = stack.pop();
                    right = new VarExpresstion(String.valueOf(charArray[++i]));
                    stack.push(new MutiExpresstion(left, right));
                    break;
                case '/':
                    left = stack.pop();
                    right = new VarExpresstion(String.valueOf(charArray[++i]));
                    stack.push(new DivExpresstion(left, right));
                    break;
                default:    //公式中的变量
                    stack.push(new VarExpresstion(String.valueOf(charArray[i])));
                    break;
            }
            this.expresstion = stack.pop();
        }
    }

    public float run(HashMap<String, Float> var) {
        return this.expresstion.interpreter(var);
    }
}
