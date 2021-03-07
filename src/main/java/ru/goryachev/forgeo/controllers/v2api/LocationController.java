package ru.goryachev.forgeo.controllers.v2api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goryachev.forgeo.models.Construction;
import ru.goryachev.forgeo.services.ConstructionService;

@RestController
@RequestMapping("/api/v2/locations")
public class LocationController {

    @Autowired
    private ConstructionService constructionService;



    @GetMapping("/constructions")
    public String constructions () {
        //test entity:
        Construction c = new Construction("Stroyka 1", "Name 1", "somedescription");
        constructionService.create(c);
        return "List of all constructions";
    }


    @GetMapping("/coordinates")
    public String coordinates () {
        return "List of all coordinates";
    }

}
