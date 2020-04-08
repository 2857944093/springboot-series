package com.czk.hope.designmode.prototype;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 16:50
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        MonsterMaker monsterMaker = new MonsterMaker();
        monsterMaker.makeRandomMonter();
    }
}
