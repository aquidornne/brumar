package com.blumar.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.blumar.controller", "com.blumar.service"})
@EntityScan("com.blumar.entity")
@EnableJpaRepositories("com.blumar.repository")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}