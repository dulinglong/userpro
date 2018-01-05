package com.zhizuobiao.userpro.controller;


import com.zhizuobiao.userpro.entity.Result;
import com.zhizuobiao.userpro.entity.User;
import com.zhizuobiao.userpro.enums.Status;
import com.zhizuobiao.userpro.service.UserService;
import com.zhizuobiao.userpro.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired private UserService userService;

    @GetMapping("/list")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/list/{id}")
    public User getUserById(@PathVariable(name = "id",required = false)Integer id){

        return userService.getUserById(id);
    }


    @GetMapping("/add")

    public Result<User> saveOne(@Validated User user,BindingResult bindingResult) throws Exception{

        if(bindingResult.hasErrors()){
            return ResultUtil.error(Status.SPRING_VALIDATION.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
       return userService.save(user);
    }


}
