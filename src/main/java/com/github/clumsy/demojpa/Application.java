package com.github.clumsy.demojpa;

import com.github.clumsy.demojpa.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories("com.github.clumsy.demojpa.repositories")
@EntityScan("com.github.clumsy.demojpa.entity")
public class Application implements CommandLineRunner {

    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      // bookRepository.save(new Book("DS-CS3","The Algorithm Design Manual","Steven S. Skiena")); //persist object
        List<Object[]> list = bookRepository.findBooks();        // get list of key value pairs
        for (Object[] ob : list){
            String key = (String)ob[0];
            String value = (String)ob[1];
            System.out.println("key : "+key+" value : "+value);
        }
    }
}
