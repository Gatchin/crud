package com.polozov.spring.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Person {

    private int id;
    @Size(message = "Name should be greater than 20 symbols")
    @Min(message = "greater than 2 symbols", value = 2L)
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
