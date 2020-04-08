package com.czk.hope.designmode.memento.demo;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:57
 * 备忘录模式
 */
public class MementoDemo {
    public static void main(String[] args) {
        show1();
        System.out.println("------------------------");
        show2();
    }

    /**
     * 该方法打印的是Memento中的state，是我们真正的存储备忘录的对象，只是用来解释Memento类的，并不符合备忘录模式
     */
    public static void show1() {
        MementoCaretaker mementoCaretaker = new MementoCaretaker();
        Originator originator = new Originator();

        originator.testState();
        mementoCaretaker.saveMemento("Originator", originator.createMemento());
        MementoIF mementoIF = mementoCaretaker.retrieveMemento("Originator");
        originator.showState(mementoIF);
        originator.testState1();
        //这种情况下，该方法实际意义不大
        //originator.restpreMemento(mementoIF);
        originator.showState(mementoIF);
    }

    /**
     * 该方法打印的是Originator中的state，是我们用来处理真正的数据的对象而已，符合备忘录模式的
     */
    public static void show2() {
        MementoCaretaker mementoCaretaker = new MementoCaretaker();
        Originator originator = new Originator();

        originator.testState();
        mementoCaretaker.saveMemento("Originator", originator.createMemento());
        MementoIF mementoIF = mementoCaretaker.retrieveMemento("Originator");
        originator.showState(mementoIF);
        originator.testState1();
        originator.restpreMemento(mementoIF);
        originator.showState1();
    }
}
