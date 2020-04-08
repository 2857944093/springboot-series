package com.czk.hope.designmode.interpreter.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 15:50
 * 解释器模式
 */
public class InterpreterDemo {
    public static void main(String[] args) throws IOException {
        /*String expStr = getExpStr();

        HashMap<String, Float> var = getValue(expStr);

        Calculator calculator = new Calculator(expStr);

        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));

        System.out.printf("Enter a math equation in reverse polish notation:\n");*/

        //Create stack of Strings
        Stack<String> rpnStack = new Stack<String>();
        //Create Scanner
        Scanner input = new Scanner(System.in);
        //String in = input.next();

        while(input != null) {
            String in = input.next();
            // Tokenize string based on spaces.
            StringTokenizer st = new StringTokenizer(in, " ", true);
            while (st.hasMoreTokens()) {
                rpnStack.push(st.nextToken());
            }
            //Send stack to Calculation Method

        }
    }

    //获得值映射
    public static HashMap<String, Float> getValue(String expStr) throws IOException {
        HashMap<String, Float> map = new HashMap<>();
        for(char ch : expStr.toCharArray()) {
            if(ch != '+' && ch != '-' ) {
                if(! map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + String.valueOf(ch) + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Float.valueOf(in));
                }
            }
        }
        return map;
    }

    private static String getExpStr() throws IOException {
        System.out.println("请输入域表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }


}
