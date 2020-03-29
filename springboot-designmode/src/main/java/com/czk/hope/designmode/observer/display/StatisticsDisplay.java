package com.czk.hope.designmode.observer.display;

import com.czk.hope.designmode.observer.subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 14:45
 * 布告板
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(temperature + ", " + humidity + ", " + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.humidity = weatherData.getHumidity();
            this.temperature = weatherData.getTemperature();
            this.pressure = weatherData.getPressure();
            display();
        }
    }
}
