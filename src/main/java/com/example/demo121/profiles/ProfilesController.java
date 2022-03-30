package com.example.demo121.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilesController {

    @Value("${spring.message}")
    private String message;

    @GetMapping("/profile")
    public String springProfiles() {

        return message;
    }

}
