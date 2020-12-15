package com.nood.hrm.dto.dto4log;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ErrorLogDto implements Serializable {

    private String userName;

    private String ip;

    private String params;

    private String description;

    private String exceptionDetail;

    private String method;

    private String browser;

    private Date createTime;
}
