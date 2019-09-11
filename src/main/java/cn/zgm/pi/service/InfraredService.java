package cn.zgm.pi.service;

import com.pi4j.io.gpio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class InfraredService {

    @Autowired
    private GpioController gpioController;


    public void infrared() throws InterruptedException {

        GpioPinDigitalInput input = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_25, PinPullResistance.PULL_DOWN);

        GpioPinDigitalOutput output = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.LOW);


        input.setShutdownOptions(true);

        while (true) {
            if (input.isHigh()) {
                System.out.println("人来了");
                output.high();
                TimeUnit.SECONDS.sleep(2);
                output.low();
                TimeUnit.SECONDS.sleep(3);
            } else {
                System.out.println("没人");
                TimeUnit.SECONDS.sleep(5);
            }
            input.setPullResistance(PinPullResistance.PULL_DOWN);
        }
    }

}
