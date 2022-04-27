package com.example.demo121.fakeapis;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Person {
    private Integer id;
    @NotBlank(message = "name cannot be blank")
    @NotNull(message = "name cannot be null")
    private String name;
    @NotBlank(message = "about cannot be blank")
    @NotNull(message = "about cannot be null")
    private String about;
    @NotNull(message = "Year cannot be null")
    private Integer birthYear;

    public Person(Integer id, String name, String about, Integer birthYear) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.birthYear = birthYear;
    }
}