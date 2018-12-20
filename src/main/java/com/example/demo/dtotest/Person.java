package com.example.demo.dtotest;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liyangdan
 * @date 2018/12/20 11:48 AM
 */
@Data
public class Person {

    @NotNull
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // getters and setters ...
}