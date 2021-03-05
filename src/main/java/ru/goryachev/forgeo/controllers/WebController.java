package ru.goryachev.forgeo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goryachev.forgeo.models.Construction;
import ru.goryachev.forgeo.services.ConstructionService;

@RestController
public class WebController {

    @Autowired
    private ConstructionService constructionService;

    @GetMapping("/main")
    public String mainPage () {
        return "APP info: ForGeo (by Lev Goryachev) webapp is based on SpringBoot, Hibernate, PostgreSQL; frontend module - ReactJS";
    }

    @GetMapping("/constructions")
    public String constructions () {
        //test entity:
        Construction c = new Construction("Stroyka 1", "Name 1", "somedescription");
        constructionService.create(c);
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
