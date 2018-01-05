package com.zhizuobiao.userpro.service;

import com.zhizuobiao.userpro.entity.Result;
import com.zhizuobiao.userpro.entity.User;
import com.zhizuobiao.userpro.enums.UserError;
import com.zhizuobiao.userpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class UserService {

@Autowired private UserRepository userRepository;


 //查询所有信息
    public List<User> getUserList(){

        return userRepository.findAll();
    }


    //根据id查询

    public User getUserById(Integer id){

        return userRepository.findOne(id);
    }


    //增加user

    @Transactional
    public Result<User> save(@Validated User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Result<User> result=new Result<>();
            result.setCode(UserError.SCORE_ERROR.getCode());
            result.setMsg(UserError.SCORE_ERROR.getMessage());
            return result;
        }else{
            Result<User> result=new Result<>();
            result.setCode(UserError.SUCESS.getCode());
            result.setMsg(UserError.SUCESS.getMessage());
            result.setData(userRepository.save(user));

            return result;
        }

    }



}
