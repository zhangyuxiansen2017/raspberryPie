package cn.zgm.pi.service;

import com.pi4j.io.gpio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Mr. Zhang
 * @description 超声波测距
 * @date 2019/9/6 14:37
 * @website https://www.zhangguimin.cn
 */
@Service
public class UltrasonicService {
    @Autowired
    private GpioController gpioController;

    @Async("taskExecutor")
    public void ultrasonic() {
        Double light = 100.0;


        GpioPinDigitalOutput led = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.LOW);
        GpioPinDigitalOutput sensorTriggerPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00);
        GpioPinDigitalInput sensorEchoPin = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

        while (true) {
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
                if (extent < light) {
                    led.high();
                } else {
                    led.low();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


