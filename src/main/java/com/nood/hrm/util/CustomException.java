package com.nood.hrm.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends  RuntimeException {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String  msg;
}