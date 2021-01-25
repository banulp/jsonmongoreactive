package com.example.jsonmongoreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookTemplateService {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public void doSomething() {

//        reactiveMongoTemplate.insert(new Person("banulp", "kyungok",42), "person");
//        System.out.println(reactiveMongoTemplate.findAll(Person.class).collectList().block().size());

//        reactiveMongoTemplate.insert("templete persion", "person");


    }


}
