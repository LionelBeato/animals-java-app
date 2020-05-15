package com.example.demo.Controller;

import com.example.demo.Model.Animal;
import com.example.demo.Repository.AnimalRepository;
import com.example.demo.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

// A controller chiefly handles routing
// this can determine the location of resources at a specific URL/URI
@RequestMapping("/api/")
@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;


//
////    For your Post method, you would need RequestBody in your parameters
////    this makes sure your arguments are mapped to the http request
////    we can have this method return a result as a well
//    @PostMapping("/animals")
//    public Animal addAnimal(@RequestBody Animal animal){
//        animalRepository.save(animal);
//        return animal;
//    }
//
//    @GetMapping("/animals")
//    public List<Animal> getAnimals(){
//        animalRepository.save(new Animal("bear", "brown"));
//        animalRepository.save(new Animal("salmon", "pink"));
//
//        return animalRepository.findAll();
//    }

//    create

//    @PostMapping
    @RequestMapping(value = "/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView postFormAnimal( Animal animal){
        animalService.createAnimal(animal);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;
    }


    @PostMapping("/")
    public void postAnimal( @RequestBody Animal animal){
        animalService.createAnimal(animal);
    }



//    read

    @GetMapping("/{id}")
    public Optional<Animal> getAnimal(@PathVariable Long id){
        return animalService.getAnimal(id);
    }


    @GetMapping("/")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @RequestMapping("/a")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.yahoo.com");
        return redirectView;
    }


//    update

    @PutMapping("/{id}")
    public Optional<Animal> updateAnimal(@RequestBody Animal newAnimal, @PathVariable Long id){
        return animalService.updateAnimal(newAnimal, id);
    }

//    delete

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
    }

}
