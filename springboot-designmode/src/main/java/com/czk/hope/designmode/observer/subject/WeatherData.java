package com.czk.hope.designmode.observer.subject;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/3/23 14:30
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    //当从气象站得到更新测试值是，更新通知者
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    //模拟气象站
    public void setMeasurements(float temperature, float humidity, float perssure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
