package cn.zgm.pi.controller;

import cn.zgm.pi.service.TrafficSignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/signal")
public class TrafficSignalController {

    @Autowired
    private TrafficSignalService trafficSignalService;

    @GetMapping(value = "/show")
    public String trafficSignal() throws InterruptedException {
        trafficSignalService.trigger();
        return "信号点亮了！";
    }
}
