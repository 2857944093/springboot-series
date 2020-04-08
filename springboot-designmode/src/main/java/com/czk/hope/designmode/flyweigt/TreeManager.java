package com.czk.hope.designmode.flyweigt;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/7 13:47
 */
public class TreeManager {
    private int length = 1000;
    private int[] xArray = new int[length] , yArray = new int[length], ageArray = new int[length];

    private Tree tree;

    public TreeManager(Tree tree) {
        this.tree = tree;

        for(int i = 0; i < length; i++) {
            xArray[i] = (int) (Math.random() * length);
            yArray[i] = (int) (Math.random() * length);
            ageArray[i] = (int) (Math.random() * length) % 6;
        }
    }

    public void displayTrees() {
        for (int i = 0; i < length; i++) {
            tree.display(xArray[i], yArray[i], ageArray[i]);
        }
    }

}
