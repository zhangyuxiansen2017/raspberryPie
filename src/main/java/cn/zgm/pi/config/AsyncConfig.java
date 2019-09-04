package cn.zgm.pi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019-09-04 20:48
 * @website https://www.zhangguimin.cn
 */
@Configuration
public class AsyncConfig {
    private static final int THREADS = Runtime.getRuntime().availableProcessors();

    @Bean("taskExecutor")
    public Executor execute() {
        Executor executor = new ThreadPoolExecutor(THREADS, 2 * THREADS, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024));
        return executor;
    }
}
