package com.czk.hope.designmode.observer;

import com.czk.hope.designmode.observer.display.CurrentConditionsDisplay;
import com.czk.hope.designmode.observer.display.StatisticsDisplay;
import com.czk.hope.designmode.observer.subject.WeatherData;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 14:23
 * 观察者模式测试类
 */
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        //注册观察者
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
