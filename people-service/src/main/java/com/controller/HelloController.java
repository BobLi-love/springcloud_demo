package com.controller;

import com.pojo.People;
import com.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class HelloController {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/hello")
    public String hello() {
        return "hello bob!";
    }

    @GetMapping("{id}")
    public People findById(@PathVariable("id") Long id) {
        return peopleService.getById(id);
    }

}
