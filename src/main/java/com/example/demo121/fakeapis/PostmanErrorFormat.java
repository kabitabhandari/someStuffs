package com.example.demo121.fakeapis;

import lombok.Data;

@Data
public class PostmanErrorFormat {
    private String message;
    private String code;

    public PostmanErrorFormat(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
