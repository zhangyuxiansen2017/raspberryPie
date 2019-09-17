package cn.zgm.pi.service.job.util;

import cn.zgm.pi.constant.ScheduleConstants;
import cn.zgm.pi.entity.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author Mr. Zhang
 * @description 抽象quartz调用
 * @date 2019-09-12 11:00
 * @website https://www.zhangguimin.cn
 */
public abstract class AbstractQuartzJob implements org.quartz.Job {
    private static final Logger log = LoggerFactory.getLogger(AbstractQuartzJob.class);

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) {
        Job job = new Job();
        BeanUtils.copyProperties(context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES), job);
        try {
            before();
            if (job != null) {
                doExecute(context, job);
            }
            after();
        } catch (Exception e) {
            log.error("任务执行异常  - ：", e);
            after();
        }
    }

    /**
     * 执行前
     */
    protected void before() {
        threadLocal.set(new Date());
    }

    /**
     * 执行后
     */
    protected void after() {
        threadLocal.remove();
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