package com.mapper;

import com.pojo.People;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface PeopleMapper extends Mapper<People> {
}
