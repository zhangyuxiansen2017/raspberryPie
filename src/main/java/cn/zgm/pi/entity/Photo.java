package cn.zgm.pi.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr. Zhang
 * @description 照片
 * @date 11:48 下午
 * @website https://www.zhangguimin.cn
 */
@Setter
@Getter
public class Photo implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 路经
     */
    private String path;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片类别
     */
    private Integer type;
    /**
     * 状态：0正常，1删除
     */
    private Integer status;

}
