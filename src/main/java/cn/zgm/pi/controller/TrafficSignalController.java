package cn.zgm.pi.controller;

import cn.zgm.pi.service.RGBLedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/led")
public class TrafficSignalController {

    @Autowired
    private RGBLedService rgbLedService;

    @GetMapping(value = "/show")
    public String trafficSignal() throws InterruptedException {
        rgbLedService.show();
        return "信号点亮了！";
    }
}
