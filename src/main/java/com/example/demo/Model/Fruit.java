package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entity annotation tells Spring that this class is a model
@Entity
public class Fruit {

//    All tables need a primary key
//    we can have this Id be our primary key
//    we can also have it be auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String color;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Fruit(){}

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
