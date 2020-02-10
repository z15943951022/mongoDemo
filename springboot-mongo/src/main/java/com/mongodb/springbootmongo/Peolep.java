package com.mongodb.springbootmongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Peolep {
    @Id
    private String id;
    private String name;
    private Integer age;
    private Integer sumage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSumage() {
        return sumage;
    }

    public void setSumage(Integer sumage) {
        this.sumage = sumage;
    }

    @Override
    public String toString() {
        return "Peolep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
