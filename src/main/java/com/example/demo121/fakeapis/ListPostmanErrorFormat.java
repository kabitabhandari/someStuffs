package com.example.demo121.fakeapis;

import lombok.Data;

import java.util.List;

@Data
public class ListPostmanErrorFormat {
    private List<String> message;
    private String code;

    public ListPostmanErrorFormat(List<String> message, String code) {
        this.message = message;
        this.code = code;
    }

}
