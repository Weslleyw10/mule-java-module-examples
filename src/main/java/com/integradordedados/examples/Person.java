package com.integradordedados.examples;

public class Person {

    private String name;
    private Integer age;

    public Person() {
        this.name = "Max Mule";
        this.age = 10;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}