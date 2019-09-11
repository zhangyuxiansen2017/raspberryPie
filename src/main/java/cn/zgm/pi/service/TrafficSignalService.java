package cn.zgm.pi.service;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficSignalService {
    @Autowired
    private GpioController gpioController;

    @Async("taskExecutor")
    public void trigger() throws InterruptedException {
        GpioPinDigitalOutput red = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
        GpioPinDigitalOutput green = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
        GpioPinDigitalOutput yellow = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);

        while (true){
            red.high();
            TimeUnit.SECONDS.sleep(5);
            flash(red);
            yellow.high();
            TimeUnit.SECONDS.sleep(2);
            yellow.low();
            green.high();
            TimeUnit.SECONDS.sleep(5);
            flash(green);
            yellow.high();
            TimeUnit.SECONDS.sleep(2);
            yellow.low();
        }

    }

    private void flash(GpioPinDigitalOutput output) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            output.low();
            TimeUnit.MILLISECONDS.sleep(500);
            output.high();
            TimeUnit.MILLISECONDS.sleep(500);
        }
        output.low();
    }
}
