package com.example.demo121.fakeapis;

public class IdNotFoundException extends RuntimeException{
    private final String message;

    public IdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
