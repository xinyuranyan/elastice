package com.lixx.elasticsearchtemplate.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lxx
 * @date 2020/5/14 21:33
 * @description
 */
@Data
public class Staff {
    /**
     * 主键
     */
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 入职时间
     */
    private Date joinDate;

    /**
     * 当前状态
     */
    private Integer status;

    /**
     * 是否删除
     */
    private boolean deleted;

    /**
     * 创建时间-时间戳
     */
    private long createTime;

    /**
     * 修改时间-时间戳
     */
    private long modifyTime;
}
