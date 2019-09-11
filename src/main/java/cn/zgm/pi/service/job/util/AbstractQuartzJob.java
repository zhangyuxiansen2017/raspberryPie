package cn.zgm.pi.service.job.util;

import cn.zgm.pi.entity.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Mr. Zhang
 * @description 抽象quartz调用
 * @date 2019-09-11 18:28
 * @website https://www.zhangguimin.cn
 */
public abstract class AbstractQuartzJob implements org.quartz.Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

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