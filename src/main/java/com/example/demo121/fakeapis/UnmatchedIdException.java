package com.example.demo121.fakeapis;

public class UnmatchedIdException extends RuntimeException {
    private final String message;

    public UnmatchedIdException(String message) {
        super(message);
        this.message = message;
    }
}

