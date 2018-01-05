package com.zhizuobiao.userpro.util;

import com.zhizuobiao.userpro.entity.Result;
import com.zhizuobiao.userpro.enums.Status;

public class ResultUtil {

    public static Result sucess(Object object){

        Result result=new Result();
        result.setData(object);
        result.setCode(Status.SUCESS.getCode());
        result.setMsg(Status.SUCESS.getMessage());

        return result;
    }


    public static Result sucess(){
        return sucess(null);
    }



    public static Result error(Integer code,String msg){

        Result result=new Result();
        result.setData(null);
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
