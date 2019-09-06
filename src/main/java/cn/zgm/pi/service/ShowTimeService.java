package cn.zgm.pi.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019-09-04 20:26
 * @website https://www.zhangguimin.cn
 */
@Service
public class ShowTimeService {

    @Autowired
    private GpioController gpioController;

    @Async("taskExecutor")
    public void showTime() {
        while (true) {
            //死循环显示时间，快速切换时人眼难察觉闪烁。
            showNum(4, LocalTime.now().getHour() / 10, PinState.HIGH);
            showNum(3, LocalTime.now().getHour() % 10, PinState.LOW);
            showNum(2, LocalTime.now().getMinute() / 10, PinState.HIGH);
            showNum(1, LocalTime.now().getMinute() % 10, PinState.HIGH);
        }
    }

    private void showNum(int no, int num, PinState pinState) {
        GpioPinDigitalOutput vc01 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_26, "", PinState.LOW);
        GpioPinDigitalOutput vc02 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00, "", PinState.LOW);
        GpioPinDigitalOutput vc03 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02, "", PinState.LOW);
        GpioPinDigitalOutput vc04 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03, "", PinState.LOW);
        GpioPinDigitalOutput gp25 = null;
        GpioPinDigitalOutput gp24 = null;
        GpioPinDigitalOutput gp23 = null;
        GpioPinDigitalOutput gp22 = null;
        GpioPinDigitalOutput gp21 = null;
        GpioPinDigitalOutput gp29 = null;
        GpioPinDigitalOutput gp28 = null;
        GpioPinDigitalOutput gp27 = null;
        if (num == 0) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.LOW);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.LOW);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.HIGH);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 1) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.HIGH);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.HIGH);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.HIGH);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.HIGH);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.HIGH);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 2) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.HIGH);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.LOW);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.HIGH);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 3) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.HIGH);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.HIGH);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 4) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.HIGH);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.HIGH);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.HIGH);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.LOW);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 5) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.HIGH);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.HIGH);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.LOW);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 6) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.HIGH);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.LOW);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.LOW);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 7) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.HIGH);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.HIGH);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.HIGH);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.HIGH);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 8) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.LOW);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.LOW);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (num == 9) {
            //A
            gp25 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, "", PinState.LOW);
            //B
            gp24 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, "", PinState.LOW);
            //C
            gp23 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, "", PinState.LOW);
            //D
            gp22 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, "", PinState.LOW);
            //E
            gp21 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, "", PinState.HIGH);
            //F
            gp29 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "", PinState.LOW);
            //G
            gp28 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "", PinState.LOW);
            //DO
            gp27 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, "", pinState);
        }
        if (no == 1) {
            vc01.high();
        }
        if (no == 2) {
            vc02.high();
        }
        if (no == 3) {
            vc03.high();
        }
        if (no == 4) {
            vc04.high();
        }
        //必须关闭io口，不然会报错某个gpio未退出
        gpioController.shutdown();
        gpioController.unprovisionPin(vc01, vc02, vc03, vc04, gp25, gp24, gp23, gp22, gp21, gp27, gp28, gp29);
    }
}
