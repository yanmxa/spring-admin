package com.nood.hrm.controller;

import com.nood.hrm.base.request.TableRequest;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.base.response.ResponseCode;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.model.User;
import com.nood.hrm.service.UserService;
import com.nood.hrm.util.MD5;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @ResponseBody
    public User user(@PathVariable String username) {
        log.info("UserController.user(): param ( username = " + username +" )");
        return userService.getUser(username);
    }

    @GetMapping("/list")
    @ResponseBody
    public Response<User> getUsers(TableRequest tableRequest) {

        tableRequest.countOffset();

        return userService.getAllUserByPage(tableRequest.getOffset(), tableRequest.getLimit());

    }

    @GetMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("user",new User());
        return "user/user-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Response<User> saveUser(UserDto userDto, Integer roleId) {
        User user = null;
        user = userService.getUserByPhone(userDto.getTelephone());
        if (user != null && !user.getId().equals(userDto.getId())) {
            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
        }

        userDto.setStatus(1);
        userDto.setPassword(MD5.crypt(userDto.getPassword()));
        return userService.save(userDto, roleId);
    }

    final String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, User user) {
        model.addAttribute(userService.getUserById(user.getId()));
        return "user/user-edit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public Response<User> updateUser(UserDto userDto, Integer roleId) {
        User user = null;
        user = userService.getUserByPhone(userDto.getTelephone());
        if (user != null && !user.getId().equals(userDto.getId())) {
            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
        }
        return userService.updateUser(userDto, roleId);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public Response deleteUser(UserDto userDto) {
        int count = userService.deleteUserById(userDto.getId());
        if (count > 0) return Response.success();
        else return Response.failure();
    }


    @GetMapping("/findUserByFuzzyUserName")
    @ResponseBody
    public Response<User> findUserByFuzzyUsername(TableRequest tableRequest, String username) {

        tableRequest.countOffset();

        return userService.getUserByFuzzyUsername(username, tableRequest.getOffset(), tableRequest.getLimit());

    }

}