package com.zhizuobiao.userpro.enums;

public enum Status {

    SUCESS(1,"成功"),

    NOT_NULL(400,"用户姓名和分数不能为空！"),

    NOT_FOUND(500,"用户未找到！"),

    SCORE_ERROR(200,"分数必须在1-100之间！"),

    NAME_ERROR(300,"名字长度为5-20！"),

    INNER_ERROR(-1,"系统错误"),

    SPRING_VALIDATION(600,"校验错误")


;



    private Integer code;
    private String message;

    Status(Integer code, String message) {
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
