package com.nood.hrm.common.logger.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Log implements Serializable {


    private Long id;

    /** 操作用户 */
    private String userName;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    /** 请求ip */
    private String ip;

    /** 异常详细  */
    private String exceptionDetail;

    /** 异常类型 */
    private String type;

    // /** 地址 */
    // private String ipAddress;

    /** 参数*/
    private String params;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    public Log( String type,Long time) {
        this.type = type;
        this.time = time;
    }

    private Date createTime = new Date();

}
