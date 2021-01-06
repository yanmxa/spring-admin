package com.nood.hrm.dto;

import lombok.Data;

@Data
public class DepartmentDto{

    private String id;

    private String parentId;

    private String checkArr = "0";

    private String title;
}
