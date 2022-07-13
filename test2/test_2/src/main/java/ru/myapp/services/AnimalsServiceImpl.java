package ru.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.myapp.enums.TypeEnum;
import ru.myapp.exceptions.NoSuchAnimalException;
import ru.myapp.models.Animal;
import ru.myapp.repositories.AnimalRepository;
import java.util.List;
import java.util.Optional;

@Component
public class AnimalsServiceImpl implements AnimalsService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalsServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public void deleteAnimal(Integer animalId) {
        animalRepository.deleteById(animalId);
    }

    @Override
    public Animal getAnimal(Integer animalId) {
        Animal animal =null;
        Optional <Animal> optional = animalRepository.findById(animalId);
        if(optional.isPresent()) {
            animal = optional.get();
        }
        return animal;
    }

    @Override
    public void saveAnimal(Animal animal) {
        TypeEnum typeEnum = TypeEnum.getType(animal.getType());
        if(typeEnum==null) {
            throw new NoSuchAnimalException("Entered type invalid");
        }
        animalRepository.save(animal);
    }
}
