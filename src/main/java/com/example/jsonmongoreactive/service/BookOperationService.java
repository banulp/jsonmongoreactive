package com.example.jsonmongoreactive.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

@Service
public class BookOperationService {

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    public void doSomething() {

//        Flux<Person> insertAll = reactiveMongoOperations.insertAll(Flux.just(new Person("Walter", "White", 50), //
//                new Person("Skyler", "White", 45), //
//                new Person("Saul", "Goodman", 42), //
//                new Person("Jesse", "Pinkman", 27)).collectList(), "person");
//
//        System.out.println(reactiveMongoOperations.findAll(Person.class).collectList().block().size());

        reactiveMongoOperations.insert("{\"name\":\"ininini6n\"}", "person").block();

        Flux<String> person = reactiveMongoOperations.findAll(String.class, "person");
        System.out.println(person.collectList().block().size());

        ObjectMapper mapper = new ObjectMapper();


        try {
            Map<String, Object> m = mapper.readValue(new File("C:\\intellij_workspace\\jsonmongoreactive\\src\\main\\resources\\test.json"), Map.class);
            System.out.println(m.size());

            for (String key : m.keySet()) {
                Map<String, Object> mm = (Map<String, Object>) m.get(key);
                mm.put("_id", key);
                reactiveMongoOperations.insert(mm, "person").block();
            }

            Flux<String> person1 = reactiveMongoOperations.findAll(String.class, "person");
            System.out.println(person1.collectList().block().size());


        } catch (IOException e) {
            e.printStackTrace();
        }

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
