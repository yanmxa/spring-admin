package com.nood.hrm.dto;

import com.nood.hrm.model.BaseEntity;
import com.nood.hrm.model.SalaryMeta;
import com.nood.hrm.util.PinyinUtil;
import lombok.Data;

@Data
public class SalaryCustomDto extends BaseEntity<Integer> {

    private String name; // 部门名称或者姓名

//    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM")
    private String date;
    private String year;
    private String month;
    private String no;

//    private String departmentName;

//    private Integer departmentId;

    // 用于和自动申城的薪资表进行关联
    public String noChinese = "序号";
    public String noAlias = "xu_hao";
    public String departmentNameAlias = "bu_men";       // 用作权限控制
    public String departmentNoAlias = "";
    public String employeeNameAlias = "xing_ming";
    public String employeeNoAlias = "gong_hao";          // 用作权限控制
    public String dateAlias = "yue_fen";                           // 日期，用作数据过滤

    public String shouldIncomeAlisa = "ying_fa_he_ji";
    public String actualIncomeAlisa = "shi_fa_gong_zi";

}
