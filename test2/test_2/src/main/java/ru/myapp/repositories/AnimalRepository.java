package ru.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myapp.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
