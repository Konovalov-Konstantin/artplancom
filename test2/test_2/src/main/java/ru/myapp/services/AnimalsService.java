package ru.myapp.services;


import ru.myapp.models.Animal;

import java.util.List;

public interface AnimalsService {
    List<Animal> getAllAnimals();

    void deleteAnimal(Integer animalId);

    Animal getAnimal(Integer animalId);

    void saveAnimal(Animal animal);
}
