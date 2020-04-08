package com.czk.hope.designmode.flyweigt;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 13:53
 */
public class FlyweigtDemo {
    public static void main(String[] args) {
        TreeManager treeManager = new TreeManager(new Tree());
        treeManager.displayTrees();
    }
}
