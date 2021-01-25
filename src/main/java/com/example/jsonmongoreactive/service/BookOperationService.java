package com.example.jsonmongoreactive.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookOperationService {

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    private ObjectMapper mapper = new ObjectMapper();

    public void doSomething() {
        // subscribe, block 의 차이는

//        Flux<Person> insertAll = reactiveMongoOperations.insertAll(Flux.just(new Person("Walter", "White", 50), //
//                new Person("Skyler", "White", 45), //
//                new Person("Saul", "Goodman", 42), //
//                new Person("Jesse", "Pinkman", 27)).collectList(), "person");
//        insertAll.subscribe();

//        public Flux<Foo> readFile() {
//            ResolvableType type = ResolvableType.forType(List.class,Foo.class);
//            Flux<DataBuffer> data = DataBufferUtils.read("classpath:test.json", new DefaultDataBufferFactory(), 4096);
//            return new Jackson2JsonDecoder().decode(data, type, null, null)
//                    .map(Foo.class::cast);
//        }

        log.info("size0 : {}", reactiveMongoOperations.findAll(Map.class, "person").collectList().block().size());

        try {
            // file size 크면 이렇게는 안될거 같은데,,, 메모리를 얼마나 잡아야하는겨
            Map<String, Map> m = mapper.readValue(new File("C:\\intellij_workspace\\jsonmongoreactive\\src\\main\\resources\\test.json"), Map.class);

            List<Map> list = m.entrySet().stream().map(e -> {
                e.getValue().put("_id", e.getKey());
                return e.getValue();
            }).collect(Collectors.toList());

//            List<Map> list = new ArrayList<Map>(m.values());

            reactiveMongoOperations.insertAll(Mono.just(list), "person").subscribe();
//            reactiveMongoOperations.insertAll(Flux.just(m).collectList(), "person").subscribe();


//            for (String key : m.keySet()) {
//                Map<String, Object> mm = (Map<String, Object>) m.get(key);
//                //mm.put("_id", key);
//                reactiveMongoOperations.insert(mm, "person").subscribe();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("size1 : {}", reactiveMongoOperations.findAll(Map.class, "person").collectList().block().size());

    }
}
