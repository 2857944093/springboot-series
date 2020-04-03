package com.czk.hope.designmode.bridge;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/4/3 15:10
 * 桥接模式
 */
public class BridgeDemo {
    public static void main(String[] args) {
        RemoteCotrol sony = new ConsreteRemode(new Sony());
        sony.on();

        RemoteCotrol rca = new ConsreteRemode(new RCA());
        rca.on();
    }
}
