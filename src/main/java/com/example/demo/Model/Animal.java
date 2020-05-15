package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long animalId;
    private String animalName;
    private String animalColor;
    private String animalEmoji;

    public String getAnimalEmoji() {
        return animalEmoji;
    }

    public void setAnimalEmoji(String animalEmoji) {
        this.animalEmoji = animalEmoji;
    }

    public Animal(){}

    public Animal(String animalName, String animalColor, String animalEmoji) {
        this.animalName = animalName;
        this.animalColor = animalColor;
        this.animalEmoji = animalEmoji;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalId, animal.animalId) &&
                Objects.equals(animalName, animal.animalName) &&
                Objects.equals(animalColor, animal.animalColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, animalName, animalColor);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", animalColor='" + animalColor + '\'' +
                '}';
    }

}
