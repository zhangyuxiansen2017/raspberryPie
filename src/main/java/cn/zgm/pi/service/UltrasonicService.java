package cn.zgm.pi.service;

import com.pi4j.io.gpio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr. Zhang
 * @description 超声波测距
 * @date 2019/9/6 14:37
 * @website https://www.zhangguimin.cn
 */
@Service
public class UltrasonicService {
    @Autowired
    private GpioController gpio;

    public List<Double> ultrasonic() {
        GpioPinDigitalOutput sensorTriggerPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
        GpioPinDigitalInput sensorEchoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

        List<Double> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                sensorTriggerPin.high();
                Thread.sleep((long) 0.01);
                sensorTriggerPin.low();

                while (sensorEchoPin.isLow()) {
                }
                long startTime = System.nanoTime();
                while (sensorEchoPin.isHigh()) {

                }
                long endTime = System.nanoTime();

                Double extent = (((endTime - startTime) / 1e3) / 2) / 29.1;
                list.add(extent);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        gpio.unprovisionPin(sensorTriggerPin, sensorEchoPin);
        return list;

    }

}


