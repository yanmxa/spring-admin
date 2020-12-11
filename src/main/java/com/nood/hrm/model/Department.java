package com.nood.hrm.model;

import lombok.Data;

@Data
public class Department extends BaseEntity<Integer> {

    private String no;

    private Integer parentId;

    private String ancestors;

    private String deptName = "";

    private Integer sort;

    private Integer status = 1;

}
