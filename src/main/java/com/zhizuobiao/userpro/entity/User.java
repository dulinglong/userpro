package com.zhizuobiao.userpro.entity;


import com.zhizuobiao.userpro.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 5,max = 20,message = "名字长度为5-20！")
    private String name;

    @Min(value = 1,message ="分数必须在1到100之间！")
    @Max(value = 100,message = "分数必须在1到100之间！")
    private Double score;

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
