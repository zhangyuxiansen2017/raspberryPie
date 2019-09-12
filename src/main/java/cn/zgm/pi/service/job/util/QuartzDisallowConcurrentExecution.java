package cn.zgm.pi.service.job.util;

import cn.zgm.pi.entity.Job;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * @author Mr. Zhang
 * @description 定时任务处理（禁止并发执行）
 * @date 2019-09-12 11:01
 * @website https://www.zhangguimin.cn
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, Job job) throws Exception {
        JobInvokeUtil.invokeMethod(job);
    }
}
