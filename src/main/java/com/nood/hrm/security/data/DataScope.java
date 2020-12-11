package com.nood.hrm.security.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DataScope {

    ALL("1"),               // 全部数据权限
    CUSTOM("2"),            // 自定数据权限
    DEPT("3"),              // 部门数据权限
    DEPT_AND_CHILD("4"),    // 部门及以下数据权限
    SELF("5");              // 仅本人数据权限

    private String code;


    public String getCode() {
        return code;
    }

}
