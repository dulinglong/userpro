package com.zhizuobiao.userpro.exception;

import com.zhizuobiao.userpro.enums.Status;

public class UserException extends RuntimeException{

    private Integer code;

    public UserException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
