package ru.goryachev.forgeo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/main")
    public String mainPage () {
        return "APP info: ForGeo (by Lev Goryachev) webapp is based on SpringBoot, Hibernate, PostgreSQL; frontend module - ReactJS";
    }

    @GetMapping("/constructions")
    public String constructions () {
        return "List of all constructions";
    }
/*
    @GetMapping("/{name}")
    public String getConstructionByName () {
        return "Construction";
    }

    @GetMapping("/{id}")
    public String getConstructionById () {
        return "Construction";
    }

*/

    @GetMapping("/coordinates")
    public String coordinates () {
        return "List of all coordinates";
    }

}
