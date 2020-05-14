package com.lixx.elasticsearchtemplate.entity.esmodel;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lxx
 * @date 2020/5/14 21:37
 * @description
 */
@Data
public class StaffEs {
    //region 员工信息
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
//endregion

    /**
     * 所属部门信息
     */
    private StaffDepartment department;

    /**
     * 拥有设备信息
     */
    private List<StaffEquipment> staffEquipments;

    @Data
    public static class StaffDepartment {
        /**
         * 部门Id
         */
        private long departmentId;

        /**
         * 部门编号
         */
        private String departmentNo;

        /**
         * 部门名称
         */
        private String departmentName;
    }

    @Data
    public static class StaffEquipment {
        /**
         * 主键
         */
        private long id;

        /**
         * 员工Id
         */
        private long staffId;

        /**
         * 设备Id
         */
        private long equipmentId;

        /**
         * 设备名称
         */
        private String name;

        /**
         * 设备编号
         */
        private String no;
    }
}
