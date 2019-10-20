package com.service;

import com.mapper.PeopleMapper;
import com.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    public People getById(Long id) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return peopleMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void insert(People people) {
        peopleMapper.insert(people);
    }
}
