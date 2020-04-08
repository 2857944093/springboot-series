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
        String expStr = getExpStr();

        HashMap<String, Float> var = getValue(expStr);

        Calculator calculator = new Calculator(expStr);

        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }

    public static void symbol() {
        System.out.printf("Enter a math equation in reverse polish notation:\n");

        //Create stack of Strings
        Stack<String> rpnStack = new Stack<String>();
        //Create Scanner
        Scanner input = new Scanner(System.in);
        //String in = input.next();

        while(input != null) {
            String in = input.nextLine();
            // Tokenize string based on spaces.
            StringTokenizer st = new StringTokenizer(in, " ", true);
            while (st.hasMoreTokens()) {
                String trim = st.nextToken().trim();
                if (!trim.equals("")) {
                    rpnStack.push(trim);
                }
            }
            //Send stack to Calculation Method
            calculate(rpnStack);
        }
    }

    public static void calculate(Stack<String> stack) {
        // Base case: stack is empty => Error, or finished
        if (!stack.isEmpty()) {
            // throw new StackUnderflowException("Empty Stack");

            // Base case: stack has 1 element, which is the answer => finished
            if (stack.size() == 1) {
                System.out.printf("Finished, Answer: %s\n", stack.peek());
            }
        }
        // Recursive case: stack more elements on it.
        if (stack.size() > 1){
            String temp1 = stack.peek();
            stack.pop();
            String temp2 = stack.peek();
            stack.pop();
            String temp3 = stack.peek();
            stack.pop();


            if (temp3.equals("+")){
                float resultant = Float.parseFloat(temp1) + Float.parseFloat(temp2);
                stack.push(String.valueOf(resultant));
                //System.out.println(resultant);
                calculate(stack);
            }

            if (temp3.equals("-")){
                float resultant = Float.parseFloat(temp1) - Float.parseFloat(temp2);
                stack.push(String.valueOf(resultant));
                //System.out.println(resultant);
                calculate(stack);
            }

            else if (temp3.equals("*")){
                float resultant = Float.parseFloat(temp1) * Float.parseFloat(temp2);
                stack.push(String.valueOf(resultant));
                //System.out.println(resultant);
                calculate(stack);
            }

            else if (temp3.equals("/")){
                float resultant = Float.parseFloat(temp1) / Float.parseFloat(temp2);
                stack.push(String.valueOf(resultant));
                //System.out.println(resultant);
                calculate(stack);
            }

            else{
                System.out.printf("Something severely has gone wrong.");
            }
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
