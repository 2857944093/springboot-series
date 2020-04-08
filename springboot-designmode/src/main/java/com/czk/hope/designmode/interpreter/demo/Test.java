package com.czk.hope.designmode.interpreter.demo;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 17:21
 */
public class Test {
    public static void main (String []args){
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
                if (st.nextToken().equals(" ")) {
                    rpnStack.push(st.nextToken());
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
}
