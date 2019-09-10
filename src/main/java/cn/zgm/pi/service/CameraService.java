package cn.zgm.pi.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class CameraService {

    public void photo(String imageName, String path, HttpServletResponse response) {
        Runtime run = Runtime.getRuntime();
        FileInputStream inputStream = null;
        BufferedInputStream bis = null;
        try {
            //拍照
            run.exec("raspistill -t 2000 -o " + path + "/" + imageName);
            //读取照片
            inputStream = new FileInputStream(new File(path + "/" + imageName));
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + imageName);
            byte[] buffer = new byte[1024];
            bis = new BufferedInputStream(inputStream);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}