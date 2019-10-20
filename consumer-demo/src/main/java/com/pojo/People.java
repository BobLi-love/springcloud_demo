package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class People {

    private Long id;

    private String name;

    private Integer age;

    private Date createTime;
}
