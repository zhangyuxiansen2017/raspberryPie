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
        GpioPinDigitalOutput vc01 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
        GpioPinDigitalOutput vc02 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
        GpioPinDigitalOutput vc03 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
        GpioPinDigitalOutput vc04 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);


        GpioPinDigitalOutput a = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.HIGH);
        GpioPinDigitalOutput b = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.HIGH);
        GpioPinDigitalOutput c = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.HIGH);
        GpioPinDigitalOutput d = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.HIGH);
        GpioPinDigitalOutput e = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.HIGH);
        GpioPinDigitalOutput f = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.HIGH);
        GpioPinDigitalOutput g = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.HIGH);

        GpioPinDigitalOutput dos = null;
        if (num == 0) {
            a.low();
            b.low();
            c.low();
            d.low();
            e.low();
            f.low();
            g.high();
        }
        if (num == 1) {
            a.high();
            b.low();
            c.low();
            d.high();
            e.high();
            f.high();
            g.high();
        }
        if (num == 2) {
            a.low();
            b.low();
            c.high();
            d.low();
            e.low();
            f.high();
            g.low();
        }
        if (num == 3) {
            a.low();
            b.low();
            c.low();
            d.low();
            e.high();
            f.high();
            g.low();
        }
        if (num == 4) {
            a.high();
            b.low();
            c.low();
            d.high();
            e.high();
            f.low();
            g.low();
        }
        if (num == 5) {
            a.low();
            b.high();
            c.low();
            d.low();
            e.high();
            f.low();
            g.low();
        }
        if (num == 6) {
            a.low();
            b.low();
            c.high();
            d.low();
            e.low();
            f.low();
            g.low();
        }
        if (num == 7) {
            a.low();
            b.low();
            c.low();
            d.high();
            e.high();
            f.high();
            g.high();
        }
        if (num == 8) {
            a.low();
            b.low();
            c.low();
            d.low();
            e.low();
            f.low();
            g.low();
        }
        if (num == 9) {
            a.low();
            b.low();
            c.low();
            d.low();
            e.high();
            f.low();
            g.low();
        }

        dos = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_23, pinState);

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
        gpioController.unprovisionPin(vc01, vc02, vc03, vc04, a, b, c, d, e, f, g, dos);
    }
}
