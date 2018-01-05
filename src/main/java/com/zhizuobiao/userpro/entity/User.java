package com.zhizuobiao.userpro.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;


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
