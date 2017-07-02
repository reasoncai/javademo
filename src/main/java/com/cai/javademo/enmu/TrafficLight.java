package com.cai.javademo.enmu;
import java.io.IOException;

import static com.cai.javademo.enmu.TrafficLight.Signal.*;

/**
 * 状态机模式实现交通信号灯
 * Created by reason on 17/7/1.
 */
public class TrafficLight {
    enum Signal{
        RED, GREEN, YELLOW
    }

    private Signal color;

    public TrafficLight(Signal color){
        this.color = color;
    }

    public void change(){
        switch (color){
            case RED: color = GREEN;
                break;
            case GREEN: color = YELLOW;
                break;
            case YELLOW: color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is "+color;
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight(GREEN);
        for (int i = 0; i < 10; i++) {
            System.out.println(trafficLight);
            trafficLight.change();
        }

    }
}
