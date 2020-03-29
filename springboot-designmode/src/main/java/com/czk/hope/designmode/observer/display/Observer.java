package com.czk.hope.designmode.observer.display;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 14:26
 * 观察者接口
 */
public interface Observer {
    void update(float temp, float humidity, float perssure);
}
