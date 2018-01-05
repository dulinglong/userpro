package com.zhizuobiao.userpro.enums;

public enum UserError {


        SCORE_ERROR(1, "分数必须在1到100之间！"),

        SUCESS(0, "成功");




    private int code;
    private String message;

    UserError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
