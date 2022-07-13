package ru.myapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AnimalException {

    // обработка исключения если введен id, которого нет в БД
    @ExceptionHandler
    public ResponseEntity<AnimalIncorrectID> animalException (NoSuchAnimalException e) {
        AnimalIncorrectID data = new AnimalIncorrectID();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    // обработка исключения если введен некорректный id
    @ExceptionHandler
    public ResponseEntity<AnimalIncorrectID> animalException (Exception e) {
        AnimalIncorrectID data = new AnimalIncorrectID();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
