package com.nood.hrm.model;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class SalaryMeta extends BaseEntity<Integer> {

    private Integer id;
    private String tableName;
    private String name;
    private String type;
    private String property;
    private String detail;
    private String history;
    private Integer isDecimal;
    private Integer status;
    private Integer sort;
    private String version = (new SimpleDateFormat("yyyy")).format(new Date());

}
