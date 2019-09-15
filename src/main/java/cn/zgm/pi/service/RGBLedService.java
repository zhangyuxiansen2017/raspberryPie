package cn.zgm.pi.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiBcmPin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Mr. Zhang
 * @description 七色光led
 * @date 2019/9/15 8:40 下午
 * @website https://www.zhangguimin.cn
 */
@Service
public class RGBLedService {
    @Autowired
    private GpioController gpioController;

    @Async("taskExecutor")
    public void show() throws InterruptedException {
        GpioPinDigitalOutput r = gpioController.provisionDigitalOutputPin(RaspiBcmPin.GPIO_16, PinState.LOW);
        GpioPinDigitalOutput g = gpioController.provisionDigitalOutputPin(RaspiBcmPin.GPIO_20, PinState.LOW);
        GpioPinDigitalOutput b = gpioController.provisionDigitalOutputPin(RaspiBcmPin.GPIO_21, PinState.LOW);

        while (true){
            //红
            r.low();
            g.high();
            b.high();
            TimeUnit.MILLISECONDS.sleep(200);
            //绿
            r.high();
            g.low();
            b.high();
            TimeUnit.MILLISECONDS.sleep(200);
            //蓝
            r.high();
            g.high();
            b.low();
            TimeUnit.MILLISECONDS.sleep(200);
            //黄
            r.low();
            g.low();
            b.high();
            TimeUnit.MILLISECONDS.sleep(200);
            //洋红
            r.low();
            g.high();
            b.low();
            TimeUnit.MILLISECONDS.sleep(200);
            //青
            r.high();
            g.low();
            b.low();
            TimeUnit.MILLISECONDS.sleep(200);
            //白
            r.low();
            g.low();
            b.low();
            TimeUnit.MILLISECONDS.sleep(200);
        }

    }
}