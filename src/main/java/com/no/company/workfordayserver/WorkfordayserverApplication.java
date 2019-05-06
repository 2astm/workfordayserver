package com.no.company.workfordayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class WorkfordayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkfordayserverApplication.class, args);
    }
}
