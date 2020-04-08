package com.czk.hope.designmode.visitor.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:43
 * 薪资访问者
 */
public class IncomeVisitor implements Visitor{
    @Override
    public void aisit(Element element) {
        Employee employee = (Employee) element;
        System.out.println(employee.getIncome());
    }
}
