package com.czk.hope.designmode.visitor.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:31
 */
public class CompensationVisitor implements Visitor {
    @Override
    public void aisit(Element element) {
        Employee employee = (Employee) element;
        System.out.println(employee.getName());
    }
}
