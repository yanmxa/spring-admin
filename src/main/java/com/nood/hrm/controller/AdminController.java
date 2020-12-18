package com.nood.hrm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author codermy
 * @createTime 2020/7/16
 */
@Controller
@RequestMapping("auth")
@Api(tags = "系统：菜单路由")
public class AdminController {


    @GetMapping("/console")
    @ApiOperation(value = "后台首页")
    public String console(){
        return "console/console1";
    }

    @GetMapping("/form/build")
    @ApiOperation(value = "后台首页")
    public String formBuild(){
        return "system/form/index";
    }

    @GetMapping("/403")
    @ApiOperation(value = "403页面")
    public String error403(){
        return "error/403";
    }

    @GetMapping("/404")
    @ApiOperation(value = "404页面")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/500")
    @ApiOperation(value = "500页面")
    public String error500(){
        return "error/500";
    }

}
