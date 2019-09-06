package cn.zgm.pi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description 主启动类
 * @author Mr. Zhang
 * @date 2019-09-05 09:16
 * @website https://www.zhangguimin.cn
 */
@SpringBootApplication
@EnableAsync
public class PiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiApplication.class, args);
    }

}
