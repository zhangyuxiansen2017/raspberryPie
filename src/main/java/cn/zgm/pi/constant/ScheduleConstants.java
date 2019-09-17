package cn.zgm.pi.constant;

/**
 * @author Mr. Zhang
 * @description 任务调度通用常量
 * @date 2019-09-12 11:01
 * @website https://www.zhangguimin.cn
 */
public interface ScheduleConstants {
    String TASK_CLASS_NAME = "TASK_CLASS_NAME";

    /**
     * 执行目标key
     */
    String TASK_PROPERTIES = "TASK_PROPERTIES";

    /**
     * 默认
     */
    String MISFIRE_DEFAULT = "0";

    /**
     * 立即触发执行
     */
    String MISFIRE_IGNORE_MISFIRES = "1";

    /**
     * 触发一次执行
     */
    String MISFIRE_FIRE_AND_PROCEED = "2";

    /**
     * 不触发立即执行
     */
    String MISFIRE_DO_NOTHING = "3";

    enum Status {
        /**
         * 正常
         */
        NORMAL("0"),
        /**
         * 暂停
         */
        PAUSE("1");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
