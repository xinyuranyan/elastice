package com.lixx.elasticsearchtemplate.entity;

import lombok.Data;

/**
 * @author lxx
 * @date 2020/5/14 21:42
 * @description 员工设备关联表
 */
@Data
public class RelStaffEquipment {
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
}
