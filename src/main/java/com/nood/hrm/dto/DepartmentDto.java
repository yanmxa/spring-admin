package com.nood.hrm.dto;

import com.nood.hrm.model.BaseEntity;
import lombok.Data;

@Data
public class DepartmentDto extends BaseEntity {

    private String id;

    private String parentId;

    private String checkArr = "0";

    private String title;
}
