package cn.zgm.pi.service.job.util;

import cn.zgm.pi.entity.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @author Mr. Zhang
 * @description 抽象quartz调用
 * @date 2019-09-11 18:28
 * @website https://www.zhangguimin.cn
 */
public abstract class AbstractQuartzJob implements org.quartz.Job {

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();


    /**
     * 执行前
     *
     * @param context 工作执行上下文对象
     * @param job     系统计划任务
     */
    protected void before(JobExecutionContext context, Job job) {
        threadLocal.set(new Date());
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param job     系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, Job job) throws Exception;
}