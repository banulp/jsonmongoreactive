none web
https://github.com/spring-projects/spring-data-examples/tree/master/mongodb/reactive
https://github.com/spring-projects/spring-data-examples/blob/master/mongodb/reactive/src/test/java/example/springdata/mongodb/people/ReactivePersonRepositoryIntegrationTest.java

https://www.oreilly.com/library/view/hands-on-reactive-programming/9781787284951/55f2586d-72bf-4fcb-aac2-8f4126e9fbb0.xhtml
https://stackoverflow.com/questions/50607034/push-a-flux-using-spring-data-with-reactive-mongodb

https://www.docs4dev.com/docs/en/spring-data-mongodb/2.2.1.RELEASE/reference/all.html
public class MongoApp {

private static final Log log = LogFactory.getLog(MongoApp.class);

public static void main(String[] args) throws Exception {

    ReactiveMongoOperations mongoOps = new ReactiveMongoOperations(new SimpleReactiveMongoDatabaseFactory(MongoClient.create(), "database"));

    mongoOps.insert(new Person("Joe", 34))
        .flatMap(p -> mongoOps.findOne(new Query(where("name").is("Joe")), Person.class))
        .doOnNext(person -> log.info(person.toString()))
        .flatMap(person -> mongoOps.dropCollection("person"))
        .subscribe();
}
}

https://springframework.guru/spring-data-mongodb-with-reactive-mongodb/