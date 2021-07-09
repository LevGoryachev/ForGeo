package ru.goryachev.forgeo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InfoController {

    @GetMapping("/about")
    public String about () {
        return "ForGeo web app based on Spring Boot, Spring Data JPA (Hibernate); frontend module - ReactJS";
    }
}
