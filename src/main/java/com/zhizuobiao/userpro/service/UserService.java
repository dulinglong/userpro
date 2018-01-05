package com.zhizuobiao.userpro.service;

import com.zhizuobiao.userpro.entity.Result;
import com.zhizuobiao.userpro.entity.User;
import com.zhizuobiao.userpro.enums.Status;
import com.zhizuobiao.userpro.exception.UserException;
import com.zhizuobiao.userpro.repository.UserRepository;
import com.zhizuobiao.userpro.util.ResultUtil;
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
    public Result<User> save(User user) throws Exception{

        if(user==null||user.getName()==null||user.getScore()==null) {
            throw new UserException(Status.NOT_NULL);
        }

            String name=user.getName();
            Double score=user.getScore();

            if(name.length()<5||name.length()>20){
                throw new UserException(Status.NAME_ERROR);
            }

            if(score<1||score>100){
                throw new UserException(Status.SCORE_ERROR);
            }
            return ResultUtil.sucess(userRepository.save(user));
        }





}
