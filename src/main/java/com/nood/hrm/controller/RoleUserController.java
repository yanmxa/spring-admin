package com.nood.hrm.controller;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.model.RoleUser;
import com.nood.hrm.service.RoleUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roleuser")
@Slf4j
@Api(tags = "系统：角色用户管理")
public class RoleUserController {

    @Autowired
    private RoleUserService roleUserService;

//    @PostMapping(value = "/getRoleUserByUserId")
//    public Response<RoleUser> getRoleUserById(String userId) {
////        log.info("RoleUserController.getRoleUserById(userId) param : " + userId);
//        return roleUserService.getRoleUserByUserId(userId);
//    }

    @PostMapping(value = "/getRoleUserByUserId")
    public Response<RoleUser> getRoleUserById(String Userid) {
//        log.info("RoleUserController.getRoleUserById(userId) param : " + userId);
//        RoleUser roleUser =
        return roleUserService.getRoleUserByUserId(Userid);

    }
}
