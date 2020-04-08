package com.czk.hope.designmode.prototype;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 16:34
 */
public class MonsterMaker {
    public CruelMonster makeRandomMonter() {
        CruelMonster cruelMonster = CruelMonster.getInstance().clone();
        System.out.println(cruelMonster.toString());
        return cruelMonster;
    }
}
