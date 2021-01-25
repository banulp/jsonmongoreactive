package com.example.jsonmongoreactive.service;

public class Person {
    private String name1;
    private String name2;
    private Integer age;

    public Person(String name1, String name2, Integer age) {
        this.name1 = name1;
        this.name2 = name2;
        this.age = age;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
