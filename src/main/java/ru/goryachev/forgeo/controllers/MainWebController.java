package ru.goryachev.forgeo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainWebController {

    @GetMapping("/about")
    public String mainPage () {
        return "APP info: ForGeo (by Lev Goryachev) webapp is based on SpringBoot, Hibernate, PostgreSQL; frontend module - ReactJS";
    }

    @GetMapping("/developers")
    public String constructions () {
        return "API documentation";
    }

}
