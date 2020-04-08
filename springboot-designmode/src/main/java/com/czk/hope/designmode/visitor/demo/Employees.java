package com.czk.hope.designmode.visitor.demo;

import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:36
 */
public class Employees extends Element{

    private HashMap<String, Employee> employeeMap;

    public Employees() {
        employeeMap = new HashMap<>();
    }

    public void attach(Employee employee) {
        employeeMap.put(employee.getName(), employee);
    }


    @Override
    public void accept(Visitor visitor) {
        for (Employee employee : employeeMap.values()) {
            employee.accept(visitor);
        }
    }
}
