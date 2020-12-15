package com.nood.hrm.service;

import com.nood.hrm.dto.dto4log.ErrorLogDto;
import com.nood.hrm.dto.dto4log.LogDto;
import com.nood.hrm.dto.dto4log.LogQuery;
import com.nood.hrm.common.logger.entity.Log;
import com.nood.hrm.common.response.Response;
import org.aspectj.lang.ProceedingJoinPoint;

public interface LogService {

    /**
     * 分页模糊查询用户日志
     * @param startPosition 起始页
     * @param limit 每页多少条数据
     * @param logQuery //查询条件
     * @return
     */
    Response<LogDto> getFuzzyInfoLogByPage(Integer startPosition, Integer limit, LogQuery logQuery);

    /**
     * 分页模糊查询错误日志
     * @param startPosition 起始页
     * @param limit 每页多少条数据
     * @param logQuery //查询条件
     * @return
     */
    Response<ErrorLogDto> getFuzzyErrorLogByPage(Integer startPosition, Integer limit, LogQuery logQuery);

    /**
     * 保存日志
     * @param userName 用户名
     * @param browser 浏览器
     * @param ip IP地址
     * @param joinPoint 切入点
     * @param log 日志信息
     */
    void save(String userName, String browser, String ip, ProceedingJoinPoint joinPoint, Log log);
    /**
     * 删除所有错误日志
     */
    void delAllByError();

    /**
     * 删除所有INFO日志
     */
    void delAllByInfo();
}
