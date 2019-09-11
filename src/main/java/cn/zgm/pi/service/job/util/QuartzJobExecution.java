package cn.zgm.pi.service.job.util;

import cn.zgm.pi.service.job.util.AbstractQuartzJob;
import cn.zgm.pi.service.job.util.JobInvokeUtil;
import com.ruoyi.project.monitor.job.domain.Job;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（允许并发执行）
 * 
 * @author ruoyi
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, Job job) throws Exception
    {
        JobInvokeUtil.invokeMethod(job);
    }
}
