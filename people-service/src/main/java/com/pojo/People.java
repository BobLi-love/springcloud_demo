package com.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

@Data
public class People {

    @Id //主键
    @KeySql(useGeneratedKeys = true)  //自增
    private Long id;

    private String name;

    private Integer age;

    private Date createTime;
}
