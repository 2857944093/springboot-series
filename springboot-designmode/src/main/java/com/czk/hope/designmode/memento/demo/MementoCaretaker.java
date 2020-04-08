package com.czk.hope.designmode.memento.demo;

import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 11:18
 */
public class MementoCaretaker {
    private HashMap<String, MementoIF> mementomap;

    public MementoCaretaker() {
        mementomap = new HashMap<>();
    }

    public MementoIF retrieveMemento(String name) {
        return mementomap.get(name);
    }

    public void saveMemento(String name, MementoIF mementoIF) {
        this.mementomap.put(name, mementoIF);
    }
}
