package com.example.demo121.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * note this class will only load if we have spring.profiles.active=dev in application.yml
 */
@Profile("dev")
@Configuration
public class DevProfileClass {
    @PostConstruct
    public void test(){
        System.out.println("Inside dev profile stuffs...");

    }

    @Bean
    public void test1(){
        System.out.println("Inside dev profile stuffs 2...");

    }

}
