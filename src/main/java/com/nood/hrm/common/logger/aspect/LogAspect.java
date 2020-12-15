package com.nood.hrm.common.logger.aspect;

import com.nood.hrm.common.logger.entity.Log;
import com.nood.hrm.service.LogService;
import com.nood.hrm.util.LogUtil;
import com.nood.hrm.common.request.RequestHolder;
import com.nood.hrm.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private LogService logService;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.nood.hrm.common.logger.aop.Log)")
    public void logPointCut() {
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("logPointCut()")
    public Object saveSysLog(ProceedingJoinPoint joinPoint)throws Throwable{

        Object repsonse;
        //记录方法的执行时间
        currentTime.set(System.currentTimeMillis());

        repsonse = joinPoint.proceed();

        //定义日志类型
        Log log = new Log("INFO", System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.save(SecurityUtil.getCurrentUsername(), LogUtil.getBrowser(request), LogUtil.getIp(request), joinPoint, log);

        return repsonse;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Log log = new Log("ERROR",System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        log.setExceptionDetail(LogUtil.getStackTrace(e));
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        logService.save(SecurityUtil.getCurrentUsername(), LogUtil.getBrowser(request), LogUtil.getIp(request), (ProceedingJoinPoint)joinPoint, log);
    }
}
