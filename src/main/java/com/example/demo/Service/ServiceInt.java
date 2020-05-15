package com.example.demo.Service;

// in a lot of applications you'll find that certain classes are defined by some sort of interface
// classes that implement that interface will typically have impl in their name
public interface ServiceInt<T> {

    T getAllItems();
    T getItemById(Long id);
    T createItem(T t);
    T deleteItemById(Long id);
    T updateItem(T t, Long id);
}
