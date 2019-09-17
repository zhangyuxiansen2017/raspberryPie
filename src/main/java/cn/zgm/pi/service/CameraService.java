package cn.zgm.pi.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class CameraService {

    @Async("taskExecutor")
    public String photo() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String image = now+".jpg";
        Runtime run = Runtime.getRuntime();
        run.exec("raspistill -t 2000 -o /home/pi/java/images/" + image);
        return image;
    }
}