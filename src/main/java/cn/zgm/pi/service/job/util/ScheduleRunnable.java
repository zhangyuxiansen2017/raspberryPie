package cn.zgm.pi.service.job.util;

import cn.zgm.pi.util.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author Mr. Zhang
 * @description 执行定时任务
 * @date 2019-09-10 17:46
 * @website https://www.zhangguimin.cn
 */
public class ScheduleRunnable implements Runnable {
    private Object target;
    private Method method;
    private String params;

    public ScheduleRunnable(String beanName, String methodName, String params)
            throws NoSuchMethodException, SecurityException {
        this.target = SpringUtils.getBean(beanName);
        this.params = params;

        if (StringUtils.isNotEmpty(params)) {
            this.method = target.getClass().getDeclaredMethod(methodName, String.class);
        } else {
            this.method = target.getClass().getDeclaredMethod(methodName);
        }
    }

    @Override
    public void run() {
        try {
            ReflectionUtils.makeAccessible(method);
            if (StringUtils.isNotEmpty(params)) {
                method.invoke(target, params);
            } else {
                method.invoke(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
