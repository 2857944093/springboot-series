package com.czk.hope.designmode.mediator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/8 10:09
 */
public class ConcreteMediator implements Mediator {
    private HashMap<String, Colleague> colleagueMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void registry(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);

        if(colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof TV) {
            interMap.put("TV", colleagueName);
        } else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                ((TV) (colleagueMap.get(interMap.get("TV")))).openTV();
                ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).openCurtains();
            } else {
                ((TV) (colleagueMap.get(interMap.get("TV")))).closeTV();
                ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).closeCurtains();
            }
        } else if (colleagueMap.get(colleagueName) instanceof TV) {
            if (stateChange == 0) {
                ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).openCurtains();
            } else {
                ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).closeCurtains();
            }
        } else if (colleagueMap.get(colleagueName) instanceof Curtains) {
            if (stateChange == 0) {
                ((TV) (colleagueMap.get(interMap.get("TV")))).openTV();
            } else {
                ((TV) (colleagueMap.get(interMap.get("TV")))).closeTV();
            }
        }
    }

    @Override
    public void sengMessage() {

    }
}
