package com.nood.hrm.model;

import lombok.Data;

@Data
public class DeptInfo {

    private String tableName = "DeptInfo";

//    private String id;
    private String deptId;       // 部门编号
    private String deptName;
    private String deptShortName;
    private String deptParentId;

    // 需要添加的字段
    private String ancestors;

    private String state = "1"; // 1, 0
    private Integer sequence;

//    public String getId() {
//        return deptId;
//    }

    public final static String defaultParentId = "001";
}
