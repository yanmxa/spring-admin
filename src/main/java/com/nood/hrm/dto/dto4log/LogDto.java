package com.nood.hrm.dto.dto4log;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogDto implements Serializable {
    private String username;

    private String ip;

    private String params;

    private String description;

    private String method;

    private Long time;

    private String browser;

    private Date createTime;
}
