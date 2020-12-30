package com.nood.hrm.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.nood.hrm.common.logger.aop.Log;
import com.nood.hrm.common.request.TableRequest;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.dto.UserInfoDto;
import com.nood.hrm.model.Department;
import com.nood.hrm.model.User;
import com.nood.hrm.model.UserInfo;
import com.nood.hrm.service.DepartmentInfoService;
import com.nood.hrm.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
@Slf4j
@Api(tags = "系统：用户管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DepartmentInfoService departmentInfoService;

//    @GetMapping("/{username}")
//    @ResponseBody
//    public UserInfo user(@PathVariable String username) {
//        log.info("UserController.user(): param ( username = " + username +" )");
////        return userInfoService.getUser(username);
//        return userInfoService.getUserByName(username);
//    }

    @GetMapping("/list")
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:user:query')")
    @ApiOperation(value="分页获取页面信息", notes = "分页获取用户信息注释")
    @ApiImplicitParam(name = "tableRequest", value = "分页查询实体类", required = false)
    public Response<UserInfo> getUsers(TableRequest tableRequest) {

        tableRequest.countOffset();

        return userInfoService.getAllUserByPage(tableRequest.getOffset(), tableRequest.getLimit(), new UserInfo());
    }

    @GetMapping(value = "/add")
//    @PreAuthorize("hasAuthority('sys:user:add')")
    public String addUser(Model model) {
        model.addAttribute("user",new UserInfo());
        return "user/user-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation(value="添加用户", notes = "添加用户")
    @Log("添加用户")
//    @PreAuthorize("hasAuthority('sys:user:add')")
    public Response<UserInfo> saveUser(UserInfo userInfo, Integer roleId) {
        return userInfoService.save(userInfo, roleId);
    }

    final String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, UserInfo user) {
//        UserDto userDto = new UserDto();
        UserInfo userInfo = userInfoService.getUserById(user.getUserid());
//        BeanUtils.copyProperties(originUser, userDto);
//        if (originUser.getDepartmentId() != null) {
//            Department dept = departmentService.getDeptById(originUser.getDepartmentId());
//            userDto.setDepartmentName(dept.getDeptName());
//        }
        if (userInfo == null) userInfo = new UserInfo();
        model.addAttribute("user", userInfo);
        return "user/user-edit";
    }


    @PostMapping(value = "/edit")
    @ResponseBody
    @ApiOperation(value="更新用户", notes = "更新用户")
    @Log("更新用户")
    public Response<UserInfo> updateUser(UserInfo userInfo, Integer roleId) {
//        System.out.println(userInfo);
        return userInfoService.updateUser(userInfo, roleId);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    @ApiOperation(value="删除用户")
    @Log("删除用户")
    public Response deleteUser(@RequestParam("Userid") String userId) {
        int count = userInfoService.deleteUserById(userId);
        if (count > 0) return Response.success();
        else return Response.failure();
    }

    @RequestMapping(value = "/deleteByIdList", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="批量删除用户")
    @Log("批量删除用户")
    public Response DeleteByIdList(@RequestParam("idList") List<String> idList) {
        for (String id : idList) {
            int count = userInfoService.deleteUserById(id);
            if (count < 0) return Response.failure("删除失败");
        }
        return Response.success();
    }


    @GetMapping("/findUserByFuzzyUserName")
    @ResponseBody
    public Response<UserInfo> findUserByFuzzyUsername(TableRequest tableRequest, String username) {

        tableRequest.countOffset();

        return userInfoService.getUserByFuzzyUsername(username, tableRequest.getOffset(), tableRequest.getLimit());

    }

    @PostMapping("/changePassword")
    @ResponseBody
    @Log("修改用户密码")
    public Response<User> changePassword(String Userid, String oldPassword, String newPassword) {
        return userInfoService.changePassword(Userid, oldPassword, newPassword);
    }
}
