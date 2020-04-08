package com.czk.hope.designmode.visitor.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:11
 * 访问者模式
 */
public class VistorDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("张三");
        employee1.setIncome(200);
        employee1.setDegree("幼儿园");
        employee1.setVacationDays(365);

        Employee employee2 = new Employee();
        employee2.setName("李四");
        employee2.setIncome(600);
        employee2.setDegree("幼儿园");
        employee2.setVacationDays(365);

        Employee employee3 = new Employee();
        employee3.setName("王五");
        employee3.setIncome(400);
        employee3.setDegree("幼儿园");
        employee3.setVacationDays(365);

        Employees employees = new Employees();
        employees.attach(employee1);
        employees.attach(employee2);
        employees.attach(employee3);

        employees.accept(new CompensationVisitor());

        employees.accept(new IncomeVisitor());
    }
}
