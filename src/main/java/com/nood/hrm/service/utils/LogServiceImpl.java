package com.nood.hrm.service.utils;

import cn.hutool.json.JSONObject;
import com.nood.hrm.mapper.LogMapper;
import com.nood.hrm.dto.dto4log.ErrorLogDto;
import com.nood.hrm.dto.dto4log.LogDto;
import com.nood.hrm.dto.dto4log.LogQuery;
import com.nood.hrm.common.logger.entity.Log;
import com.nood.hrm.service.LogService;
import com.nood.hrm.common.response.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Response<LogDto> getFuzzyInfoLogByPage(Integer startPosition, Integer limit, LogQuery logQuery) {
        int count = logMapper.getFuzzyLogCount(logQuery);
        List<LogDto> fuzzyLogByPage = logMapper.getFuzzyLogByPage(startPosition, limit, logQuery);
        return Response.success(count, fuzzyLogByPage);
    }

    @Override
    public Response<ErrorLogDto> getFuzzyErrorLogByPage(Integer startPosition, Integer limit, LogQuery logQuery) {
        List<ErrorLogDto> fuzzyErrorLogByPage = logMapper.getFuzzyErrorLogByPage(startPosition, limit, logQuery);
        return Response.success(fuzzyErrorLogByPage.size(), fuzzyErrorLogByPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String userName, String browser, String ip, ProceedingJoinPoint joinPoint, Log log) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.nood.hrm.common.logger.aop.Log customLog = method.getAnnotation(com.nood.hrm.common.logger.aop.Log.class);
        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";
        StringBuilder params = new StringBuilder("{");
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params.append(" ").append(argNames[i]).append(": ").append(argValues[i]);
            }
        }
        // 描述
        if (log != null) {
            log.setDescription(customLog.value());
        }
        assert log != null;
        log.setIp(ip);
        String loginPath = "login";
        if(loginPath.equals(signature.getName())){
            try {
                assert argValues != null;
                userName = new JSONObject(argValues[0]).get("userName").toString();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        log.setMethod(methodName);
        log.setUserName(userName);
        log.setParams(params.toString() + " }");
        log.setBrowser(browser);
        logMapper.save(log);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delAllByError() {
        logMapper.delAllByInfo("ERROR");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delAllByInfo() {
        logMapper.delAllByInfo("INFO");
    }
}
