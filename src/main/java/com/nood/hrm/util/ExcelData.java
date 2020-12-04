package com.nood.hrm.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExcelData implements Serializable {
    // 表头
    private List<String> heads;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String sheetName;

    private String fileName;

}
