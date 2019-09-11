package cn.zgm.pi.controller;

import cn.zgm.pi.entity.Job;
import cn.zgm.pi.service.job.JobService;
import cn.zgm.pi.service.job.TaskService;
import cn.zgm.pi.util.ReflectUtil;
import cn.zgm.pi.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author zhang
 * @date 2018年12月11日 下午4:24:41
 */
@Controller
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    private JobService jobService;

    /**
     * 获取所有任务页面
     *
     * @param map
     * @param job
     * @return
     */
    @GetMapping(value = "/list")
    public String list(ModelMap map, Job job) {
        List<Job> jobs = jobService.selectJobList(job);
        map.put("jobs", jobs);
        return "jobList";
    }

    /**
     * 暂停任务
     *
     * @param jobId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/stopJob")
    public ResultInfo stopJob(Long jobId) {
        int i = jobService.pauseJob(jobId);
        if (i > 0) {
            return ResultInfo.success();
        }
        return ResultInfo.fail();
    }

    /**
     * 定时执行
     *
     * @param jobId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/doTimedJob")
    public ResultInfo doTimedJob(Long jobId) {
        int i = jobService.resumeJob(jobId);
        if (i > 0) {
            return ResultInfo.success();
        }
        return ResultInfo.fail();
    }

    /**
     * 立刻执行一次
     *
     * @param jobId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/doJob")
    public ResultInfo doJob(Long jobId) {
        int i = jobService.run(jobId);
        if (i > 0) {
            return ResultInfo.success();
        }
        return ResultInfo.fail();
    }

    @ResponseBody
    @GetMapping(value = "/getMethods")
    public ResultInfo getMethods() {
        Map<String, List<String>> methods = ReflectUtil.getMethods(new TaskService());
        return ResultInfo.success().data("methods", methods);
    }


}
