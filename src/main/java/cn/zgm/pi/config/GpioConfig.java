package cn.zgm.pi.config;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019-09-04 20:28
 * @website https://www.zhangguimin.cn
 */
@Configuration
public class GpioConfig {

    @Bean
    public GpioController gpioController() {
        GpioController gpioController = GpioFactory.getInstance();
        return gpioController;
    }

}
