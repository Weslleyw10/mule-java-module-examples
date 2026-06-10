package com.integradordedados.examples;

public class Employee extends Person {

    private String company;

    public Employee(String name, Integer age, String company) {
        super(name, age);
        this.company = company;
    }
}