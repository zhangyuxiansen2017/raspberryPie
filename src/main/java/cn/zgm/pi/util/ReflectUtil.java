package cn.zgm.pi.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr. Zhang
 * @description 反射工具
 * @date 2019/9/11 16:01
 * @website https://www.zhangguimin.cn
 */
public class ReflectUtil {

    public static Map<String, List<String>> getMethods(Object object) {
        Map<String, List<String>> map = new HashMap<>();
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            List<String> list = new ArrayList<>(parameterTypes.length);
            for (Class<?> parameterType : parameterTypes) {
                list.add(parameterType.getSimpleName());
            }
            map.put(method.getName(), list);
        }
        return map;
    }
}
