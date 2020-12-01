package com.nood.hrm.controller;

import com.nood.hrm.base.request.TableRequest;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("salary")
@Slf4j
public class SalaryController {

    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('sys:user:query')")
    public String getUsers() {
        return "salary/salary-list";
    }

}
