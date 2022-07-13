package ru.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.myapp.exceptions.AnimalIncorrectID;
import ru.myapp.exceptions.NoSuchAnimalException;
import ru.myapp.models.Animal;
import ru.myapp.services.AnimalsService;

import java.util.List;

@RestController
public class AnimalController {

    private final AnimalsService animalsService;

    public AnimalController(AnimalsService animalsService) {
        this.animalsService = animalsService;
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        List<Animal> animals = animalsService.getAllAnimals();
        return animals;
    }

    @GetMapping("/animals/{animal-id}")
    public Animal getAnimal(@PathVariable("animal-id") Integer animalId){
        Animal animal = animalsService.getAnimal(animalId);
        if(animal == null) {
            throw new NoSuchAnimalException("No animal with id = " + animalId);
        }
        return animal;
    }

    @PostMapping("/animals")
    public Animal addNewAnimal(@RequestBody Animal animal) {
        animalsService.saveAnimal(animal);
        return animal;
    }

    @PutMapping("/animals")
    public Animal updateAnimal(@RequestBody Animal animal){
        animalsService.saveAnimal(animal);
        return animal;
    }

    @DeleteMapping("/animals/{animal-id}")
    public String deleteAnimal(@PathVariable("animal-id") Integer animalId){
        animalsService.deleteAnimal(animalId);
        return "Animal with id = " + animalId + " was deleted";
    }

}
