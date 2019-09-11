package cn.zgm.pi.service.job.util;

import org.quartz.CronExpression;

/**
 * @author Mr. Zhang
 * @description cron表达式工具类
 * @date 2019-09-10 17:45
 * @website https://www.zhangguimin.cn
 */
public class CronUtils {
    /**
     * 返回一个布尔值代表一个给定的Cron表达式的有效性
     *
     * @param cronExpression Cron表达式
     * @return boolean 表达式是否有效
     */
    public static boolean isValid(String cronExpression) {
        return CronExpression.isValidExpression(cronExpression);
    }

}
