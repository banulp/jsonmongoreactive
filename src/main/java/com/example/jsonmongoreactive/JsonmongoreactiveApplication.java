package com.example.jsonmongoreactive;

import com.example.jsonmongoreactive.service.BookTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JsonmongoreactiveApplication {
//		implements CommandLineRunner {

    @Autowired
    private BookTemplateService bookService;

    public static void main(String[] args) {
        SpringApplication.run(JsonmongoreactiveApplication.class, args);
    }

//	@Override
//	public void run(String... args) throws Exception {
//		bookService.doSomething();
//	}

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            bookService.doSomething();
        };
    }
}
