package com.nood.hrm.controller;


import com.nood.hrm.common.logger.aop.Log;
import com.nood.hrm.dto.dto4log.ErrorLogDto;
import com.nood.hrm.dto.dto4log.LogDto;
import com.nood.hrm.dto.dto4log.LogQuery;
import com.nood.hrm.service.LogService;
import com.nood.hrm.common.request.TableRequest;
import com.nood.hrm.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("log")
@Api(tags = "系统：日志管理")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/index")
    public String logIndex(){
        return "log";
    }

    @GetMapping("/table")
    @ResponseBody
    @ApiOperation(value = "日志列表")
//    @PreAuthorize("hasAnyAuthority('log:list')")
    // @Log("获取日志列表")
    public Response<LogDto> logList(TableRequest tableRequest, LogQuery logQuery){
        tableRequest.countOffset();
        logQuery.setLogType("INFO");
        return logService.getFuzzyInfoLogByPage(tableRequest.getOffset(), tableRequest.getLimit(), logQuery);
    }

    @DeleteMapping("/table")
    @ResponseBody
    @ApiOperation("删除所有INFO日志")
//    @PreAuthorize("hasAnyAuthority('log:del')")
    @Log("删除所有INFO日志")
    public Response<Object> delAllByInfo(){
        logService.delAllByInfo();
        return Response.success("删除成功！");
    }

    @GetMapping("/error/index")
    public String errorLogIndex(){
        return "log/errorLog";
    }

    @GetMapping("/error/log")
    @ResponseBody
    @ApiOperation(value = "错误日志")
//    @PreAuthorize("hasAnyAuthority('errorLog:list')")
    public Response<ErrorLogDto> errorLogList(TableRequest tableRequest, LogQuery logQuery){
        tableRequest.countOffset();
        logQuery.setLogType("ERROR");
        return logService.getFuzzyErrorLogByPage(tableRequest.getOffset(), tableRequest.getLimit(), logQuery);
  }
    @DeleteMapping("/error/log")
    @Log("删除所有ERROR日志")
    @ResponseBody
    @ApiOperation("删除所有ERROR日志")
//    @PreAuthorize("hasAnyAuthority('errorLog:del')")
    public Response<Object> delAllByError(){
        logService.delAllByError();
        return Response.success("删除成功！");
    }

}
