package com.example.demo.Service;

import com.example.demo.Model.Animal;
import com.example.demo.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A service is a class that will properly hold your business logic
// business logic can be thought of as any real actions or behavior of your backend application
@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

//    Now we need to define our CRUD methods


//    Create

    public void createAnimal(Animal animal){
        animalRepository.save(animal);
    }

//    Read

    public Optional<Animal> getAnimal(Long id){
        return animalRepository.findById(id);
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

//    Update

    public Optional<Animal> updateAnimal(Animal newAnimal, Long id){
       animalRepository.findById(id).map(animal -> {
            animal.setAnimalName(newAnimal.getAnimalName());
            animal.setAnimalColor(newAnimal.getAnimalColor());
            return animalRepository.save(animal);
        });
        return animalRepository.findById(id);
    }

//    Delete

    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }



}
