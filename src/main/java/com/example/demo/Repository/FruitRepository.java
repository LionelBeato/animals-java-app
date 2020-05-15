package com.example.demo.Repository;

import com.example.demo.Model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {


}
