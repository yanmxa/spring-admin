package com.nood.hrm.dto;

import lombok.Data;

@Data
public class SalaryMetaDto {

    private String field;
    private String title;
    private String align = "center";
    private String fixed = "";

    public SalaryMetaDto(String field, String title) {
        this.field = field;
        this.title = title;
    }
}
