package com.nood.hrm.dto;

import com.nood.hrm.model.BaseEntity;
import lombok.Data;

@Data
public class SalaryCustomDto extends BaseEntity<Integer> {

    private String name; // 部门名称或者姓名

//    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM")
    private String date;

//    private String departmentName;

//    private Integer departmentId;

    // 用于和自动申城的薪资表进行关联
    private String departmentNameAlias = "bu_men_ming_cheng";       // 用作权限控制
    private String employeeNameAlias = "yuan_gong_ming_zi";
    private String employeeNoAlias = "yuan_gong_bian_hao";          // 用作权限控制
    private String dateAlias = "yue_fen";                           // 日期，用作数据过滤

}
