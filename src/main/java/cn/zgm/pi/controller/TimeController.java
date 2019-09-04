package cn.zgm.pi.controller;

import cn.zgm.pi.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019-09-04 20:33
 * @website https://www.zhangguimin.cn
 */
@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/show")
    public String show() {
        showTimeService.showTime();
        return "成功！";
    }
}
