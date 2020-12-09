package com.nood.hrm.dto;

import com.nood.hrm.model.BaseEntity;
import lombok.Data;

@Data
public class DepartmentDto extends BaseEntity {

    private Integer id;

    private Integer parentId;

    private String checkArr = "0";

    private String title;
}
