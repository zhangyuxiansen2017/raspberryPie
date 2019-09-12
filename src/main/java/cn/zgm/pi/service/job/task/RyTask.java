package cn.zgm.pi.service.job.task;

import org.springframework.stereotype.Component;

/**
 * @author Mr. Zhang
 * @description 定时任务调度测试
 * @date 2019-09-12 11:00
 * @website https://www.zhangguimin.cn
 */
@Component("ryTask")
public class RyTask {
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(s + b + l + d + i);
    }

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams() {
        System.out.println("执行无参方法");
    }
}
