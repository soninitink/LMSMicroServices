package com.tcs.edureka.lmsbookservice;

import com.tcs.edureka.lmsbookservice.models.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.tcs.edureka.lmsbookservice.models.Author;
@SpringBootApplication
public class LmsBookServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(LmsBookServiceApplication.class, args);

    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
