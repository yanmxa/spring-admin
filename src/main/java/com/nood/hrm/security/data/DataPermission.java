package com.nood.hrm.security.data;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermission {

    /**
     * 部门表的别名
     */
    public String departmentAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}