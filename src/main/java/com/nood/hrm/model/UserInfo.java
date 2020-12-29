package com.nood.hrm.model;

import lombok.Data;

@Data
public class UserInfo {
    private String tableName = "SD_UserInfo";

    private String Userid;
    private String Password;
    private String NameCn;
    private String NamePy;
    private String DeptId;
    private String DeptName;
    private String Gender;
    private String Education;
    private String OfficeTel;
    private String OfficeLocation;
    private String Title;

    private String roleName;
//    private String ID;

}
