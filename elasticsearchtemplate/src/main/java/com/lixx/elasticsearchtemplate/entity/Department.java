package com.lixx.elasticsearchtemplate.entity;

import lombok.Data;

/**
 * @author lxx
 * @date 2020/5/14 21:32
 * @description
 */
@Data
public class Department {
    /**
     * 主键
     */
    private long id;

    /**
     * 部门编号
     */
    private String departmentNo;

    /**
     * 部门名称
     */
    private String departmentName;

}
