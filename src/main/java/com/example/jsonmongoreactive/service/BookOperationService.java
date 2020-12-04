package com.example.jsonmongoreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookOperationService {

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    public void doSomething(){

        reactiveMongoOperations.indexOps("aa");


//        reactiveMongoTemplate.insert()


    }


//    String json = "{ 'name' : 'lokesh' , " +
//            "'website' : 'howtodoinjava.com' , " +
//            "'address' : { 'addressLine1' : 'Some address' , " +
//            "'addressLine2' : 'Karol Bagh' , " +
//            "'addressLine3' : 'New Delhi, India'}" +
//            "}";
//
//    DBObject dbObject = (DBObject)JSON.parse(json);
//
//        collection.insert(dbObject);

}
