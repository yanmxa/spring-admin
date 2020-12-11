package com.nood.hrm.controller;

import com.nood.hrm.base.request.TableRequest;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.base.response.ResponseCode;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.model.Department;
import com.nood.hrm.model.User;
import com.nood.hrm.service.DepartmentService;
import com.nood.hrm.service.UserService;
import com.nood.hrm.util.MD5;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{username}")
    @ResponseBody
    public User user(@PathVariable String username) {
        log.info("UserController.user(): param ( username = " + username +" )");
        return userService.getUser(username);
    }

    @GetMapping("/list")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:query')")
    public Response<UserDto> getUsers(TableRequest tableRequest) {

        tableRequest.countOffset();

        return userService.getAllUserByPage(tableRequest.getOffset(), tableRequest.getLimit(), new User());
    }

    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public String addUser(Model model) {
        model.addAttribute("user",new UserDto());
        return "user/user-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:user:add')")
    public Response<User> saveUser(UserDto userDto, Integer roleId) {


        return userService.save(userDto, roleId);
    }

    final String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, User user) {
        UserDto userDto = new UserDto();
        User originUser = userService.getUserById(user.getId());
        BeanUtils.copyProperties(originUser, userDto);
        if (originUser.getDepartmentId() != null) {
            Department dept = departmentService.getDeptById(originUser.getDepartmentId());
            userDto.setDepartmentName(dept.getDeptName());
        }
        model.addAttribute("user", userDto);
        return "user/user-edit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public Response<User> updateUser(UserDto userDto, Integer roleId) {

        return userService.updateUser(userDto, roleId);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public Response deleteUser(UserDto userDto) {
        int count = userService.deleteUserById(userDto.getId());
        if (count > 0) return Response.success();
        else return Response.failure();
    }

    @RequestMapping(value = "/deleteByIdList", method = RequestMethod.POST)
    @ResponseBody
    public Response DeleteByIdList(@RequestParam("idList") List<Integer> idList) {
        for (Integer id : idList) {
            int count = userService.deleteUserById(id.longValue());
            if (count < 0) return Response.failure("删除失败");
        }
        return Response.success();
    }


    @GetMapping("/findUserByFuzzyUserName")
    @ResponseBody
    public Response<User> findUserByFuzzyUsername(TableRequest tableRequest, String username) {

        tableRequest.countOffset();

        return userService.getUserByFuzzyUsername(username, tableRequest.getOffset(), tableRequest.getLimit());

    }

    @PostMapping("/changePassword")
    @ResponseBody
    public Response<User> changePassword(String username, String oldPassword, String newPassword) {
        return userService.changePassword(username, oldPassword, newPassword);
    }

}