package com.example.demo.Controller;

import com.example.demo.Model.Fruit;
import com.example.demo.Repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// here we have a "controller" class
// controllers will dictate what occurs at any given endpoint
// an endpoint is a location defined by your URL

// this annotation helps Spring know this class will act as a controller
// doing so will create what is referred to as a java "bean"
// "beans" can be thought of as java objects that perform some...
// ...sort of action in a system (it's more complicated than that, but lets...
// ...keep it simple)
@RestController
public class MainController {

    @Autowired
    FruitRepository fruitRepository;

//    creating two different Fruits that we'll later return
    Fruit apple = new Fruit( "Apple", "red");
    Fruit papaya = new Fruit( "Papaya", "orange");

//    creating a list that we can return as well
//    ArrayList<Fruit> fruitArrayList = new ArrayList<>();

//    GetMapping is used to define our URL endpoint
//    this endpoint can be any legal string value
    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }

    @GetMapping("/lionel")
    public String getName(){
        return "My Name is Lionel";
    }

//    even Java objects can be returned
//    these objects will render as JSON objects over the web
    @GetMapping("/apple")
    public Fruit getFruit(){
        return apple;
    }

    @GetMapping("/papaya")
    public Fruit getPapaya(){
        return papaya;
    }

//    here, we're returning a fruit list
//    this list will also render as a JSON object
//    essentially, valid Java objects will resolve to a JSON objects with few exceptions
    @GetMapping("/allfruits")
    public List<Fruit> getFruitArrayList(){
        fruitRepository.save(apple);
        fruitRepository.save(papaya);
        return fruitRepository.findAll();
    }


}
