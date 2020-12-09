package com.nood.hrm.dto;

import lombok.Data;

@Data
public class SalaryItemDto {

    private String field;
    private String title;

    public SalaryItemDto(String field, String title) {
        this.field = field;
        this.title = title;
    }
}
