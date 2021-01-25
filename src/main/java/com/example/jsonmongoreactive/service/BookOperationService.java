package com.example.jsonmongoreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BookOperationService {

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    public void doSomething(){

//        Flux<Person> insertAll = reactiveMongoOperations.insertAll(Flux.just(new Person("Walter", "White", 50), //
//                new Person("Skyler", "White", 45), //
//                new Person("Saul", "Goodman", 42), //
//                new Person("Jesse", "Pinkman", 27)).collectList(), "person");
//
//        System.out.println(reactiveMongoOperations.findAll(Person.class).collectList().block().size());

        Flux<String> person = reactiveMongoOperations.findAll(String.class, "person");
        System.out.println(person.collectList().block().size());

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
