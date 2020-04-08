package com.czk.hope.designmode.memento.demo;

import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 11:22
 */
public class Originator {

    private HashMap<String, String> state;

    public Originator() {
        state = new HashMap<>();
    }

    public MementoIF createMemento() {
        return new Memento(state);
    }

    public void restpreMemento(MementoIF mementoIF) {
        state = ((Memento) mementoIF).getState();
    }

    public void showState(MementoIF mementoIF) {
        mementoIF.showState();
    }

    public void showState1() {
        System.out.println(state.toString());
    }

    public void testState() {
        state.put("blood", "500");
        state.put("enemy", "5");
        state.put("progress", "gate1 end");
    }

    public void testState1() {
        state.put("blood", "1000");
        state.put("enemy", "10");
        state.put("progress", "gate2 end");
        state.put("a", "good");
    }


    /**
     * 该类在Demo类中有解释
     */
    private class Memento implements MementoIF {

        private HashMap<String, String> state;

        private Memento(HashMap state) {
            this.state = new HashMap<>(state);
        }

        private HashMap getState() {
            return state;
        }

        private void setState(HashMap state) {
            this.state = state;
        }

        @Override
        public void showState() {
            System.out.println(state.toString());
        }
    }

}
