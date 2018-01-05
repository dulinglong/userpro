package com.zhizuobiao.userpro.handle;


import com.zhizuobiao.userpro.entity.Result;
import com.zhizuobiao.userpro.enums.Status;
import com.zhizuobiao.userpro.exception.UserException;
import com.zhizuobiao.userpro.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

    private static final Logger logger= LoggerFactory.getLogger(HandleException.class);

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e){

        if(e instanceof UserException){
            UserException userException= (UserException) e;
            return ResultUtil.error(userException.getCode(),userException.getMessage());
        }else{

            logger.info("【系统错误】",e);
            return ResultUtil.error(Status.INNER_ERROR.getCode(),Status.INNER_ERROR.getMessage());
        }


    }

}
