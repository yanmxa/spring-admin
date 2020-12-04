package com.nood.hrm.model;

import lombok.Data;

@Data
public class SalaryMeta extends BaseEntity<Integer> {

    private Integer id;
    private String name;
    private String type;
    private String property;
    private String detail;
    private String history;
    private Integer isDecimal;
    private Integer status;

}
