package cn.zgm.pi.util;

import cn.zgm.pi.entity.Job;
import cn.zgm.pi.service.job.util.ScheduleConstants;
import cn.zgm.pi.service.job.util.ScheduleRunnable;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 定时任务
 *
 * @author ruoyi
 * QuartzJobBean
 */
@DisallowConcurrentExecution
public class ScheduleJob extends QuartzJobBean {

    private ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext context) {
        Job job = (Job) context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES);
        try {
            // 执行任务
            ScheduleRunnable task = new ScheduleRunnable(job.getJobName(), job.getMethodName(), job.getMethodParams());
            Future<?> future = service.submit(task);
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
