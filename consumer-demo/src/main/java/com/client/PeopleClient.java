package com.client;

import com.pojo.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("people-service")
public interface PeopleClient {

    @GetMapping("people/{id}")
    People getById(@PathVariable("id") Integer id);
}
