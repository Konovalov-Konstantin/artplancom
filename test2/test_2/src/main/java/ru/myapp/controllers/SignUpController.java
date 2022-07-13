package ru.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.myapp.services.SignUpService;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public String getSignUpPage(){
        return "/signUp";
    }

    @PostMapping
    public String signUpUser(@RequestParam("name") String name,
                             @RequestParam("password") String password){
        signUpService.signUpUser(name, password);
        return "redirect:/signIn";
    }

}
