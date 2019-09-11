package cn.zgm.pi.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/9/10 17:50
 * @website https://www.zhangguimin.cn
 */
@Data
public class ResultInfo {

    private Integer code;
    private String msg;

    private Map<String, Object> data = new HashMap<>();

    public static ResultInfo success() {
        ResultInfo result = new ResultInfo();
        result.setCode(0);
        result.setMsg("处理成功！");
        return result;
    }

    public static ResultInfo fail() {
        ResultInfo result = new ResultInfo();
        result.setCode(1);
        result.setMsg("处理失败！");
        return result;
    }

    public ResultInfo data(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }
}
