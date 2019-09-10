package cn.zgm.pi.controller;

import cn.zgm.pi.service.UltrasonicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/9/6 15:13
 * @website https://www.zhangguimin.cn
 */
@RestController
@RequestMapping("/long")
public class UltrasonicController {

    @Autowired
    private UltrasonicService ultrasonicService;

    @GetMapping("/get")
    public List<Double> getDistance() {
        List<Double> list = ultrasonicService.ultrasonic();
        return list;
    }
}
