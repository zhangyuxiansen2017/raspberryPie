package cn.zgm.pi.controller;

import cn.zgm.pi.service.CameraService;
import cn.zgm.pi.util.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/9/15 10:28 下午
 * @website https://www.zhangguimin.cn
 */
@Controller
@RequestMapping(value = "/camera")
public class CameraController {

    private final CameraService cameraService;

    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping(value = "/take")
    @ResponseBody
    public ResultInfo take() throws IOException {
        String path = cameraService.photo();
        return ResultInfo.success().data("url", path);
    }
}