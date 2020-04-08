package com.czk.hope.designmode.visitor.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 15:26
 */
public class Employee extends Element{
    private String name;
    private double income;
    private int vacationDays;
    private String degree;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * 双重注入Visitor <-> this
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.aisit(this);
    }
}
