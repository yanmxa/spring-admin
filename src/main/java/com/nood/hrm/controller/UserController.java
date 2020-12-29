//package com.nood.hrm.controller;
//
//import com.nood.hrm.common.logger.aop.Log;
//import com.nood.hrm.common.request.TableRequest;
//import com.nood.hrm.common.response.Response;
//import com.nood.hrm.dto.UserDto;
//import com.nood.hrm.model.Department;
//import com.nood.hrm.model.User;
//import com.nood.hrm.service.DepartmentService;
//import com.nood.hrm.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.request.WebRequest;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//
//@Controller
//@RequestMapping("user")
//@Slf4j
//@Api(tags = "系统：用户管理")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private DepartmentService departmentService;
//
//    @GetMapping("/{username}")
//    @ResponseBody
//    public User user(@PathVariable String username) {
//        log.info("UserController.user(): param ( username = " + username +" )");
//        return userService.getUser(username);
//    }
//
//    @GetMapping("/list")
//    @ResponseBody
////    @PreAuthorize("hasAuthority('sys:user:query')")
//    @ApiOperation(value="分页获取页面信息", notes = "分页获取用户信息注释")
//    @ApiImplicitParam(name = "tableRequest", value = "分页查询实体类", required = false)
//    public Response<UserDto> getUsers(TableRequest tableRequest) {
//
//        tableRequest.countOffset();
//
//        return userService.getAllUserByPage(tableRequest.getOffset(), tableRequest.getLimit(), new User());
//    }
//
//    @GetMapping(value = "/add")
////    @PreAuthorize("hasAuthority('sys:user:add')")
//    public String addUser(Model model) {
//        model.addAttribute("user",new UserDto());
//        return "user/user-add";
//    }
//
//    @PostMapping(value = "/add")
//    @ResponseBody
//    @ApiOperation(value="添加用户", notes = "添加用户")
//    @Log("添加用户")
////    @PreAuthorize("hasAuthority('sys:user:add')")
//    public Response<User> saveUser(UserDto userDto, Integer roleId) {
//
//
//        return userService.save(userDto, roleId);
//    }
//
//    final String pattern = "yyyy-MM-dd";
//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
//    }
//
//    @GetMapping(value = "/edit")
//    public String editUser(Model model, User user) {
//        UserDto userDto = new UserDto();
//        User originUser = userService.getUserById(user.getId());
//        BeanUtils.copyProperties(originUser, userDto);
//        if (originUser.getDepartmentId() != null) {
//            Department dept = departmentService.getDeptById(originUser.getDepartmentId());
//            userDto.setDepartmentName(dept.getDeptName());
//        }
//        model.addAttribute("user", userDto);
//        return "user/user-edit";
//    }
//
//    @PostMapping(value = "/edit")
//    @ResponseBody
//    @ApiOperation(value="更新用户", notes = "更新用户")
//    @Log("更新用户")
//    public Response<User> updateUser(UserDto userDto, Integer roleId) {
//
//        return userService.updateUser(userDto, roleId);
//    }
//
//    @GetMapping(value = "/delete")
//    @ResponseBody
//    @ApiOperation(value="删除用户")
//    @Log("删除用户")
//    public Response deleteUser(UserDto userDto) {
//        int count = userService.deleteUserById(userDto.getId());
//        if (count > 0) return Response.success();
//        else return Response.failure();
//    }
//
//    @RequestMapping(value = "/deleteByIdList", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value="批量删除用户")
//    @Log("批量删除用户")
//    public Response DeleteByIdList(@RequestParam("idList") List<Integer> idList) {
//        for (Integer id : idList) {
//            int count = userService.deleteUserById(id.longValue());
//            if (count < 0) return Response.failure("删除失败");
//        }
//        return Response.success();
//    }
//
//
//    @GetMapping("/findUserByFuzzyUserName")
//    @ResponseBody
//    public Response<User> findUserByFuzzyUsername(TableRequest tableRequest, String username) {
//
//        tableRequest.countOffset();
//
//        return userService.getUserByFuzzyUsername(username, tableRequest.getOffset(), tableRequest.getLimit());
//
//    }
//
//    @PostMapping("/changePassword")
//    @ResponseBody
//    @Log("修改用户密码")
//    public Response<User> changePassword(String username, String oldPassword, String newPassword) {
//        return userService.changePassword(username, oldPassword, newPassword);
//    }
//
//}