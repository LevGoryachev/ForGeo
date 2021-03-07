package ru.goryachev.forgeo.controllers.v2api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.forgeo.models.Construction;
import ru.goryachev.forgeo.services.ConstructionService;

@RestController
@RequestMapping("/api/v2/constructions")
public class ConstructionController {

    @Autowired
    private ConstructionService constructionService;

    //@GetMapping (value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping (value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Construction> getConstruction (@PathVariable ("id") int ConstructionID) {
//        if (ConstructionID == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        Construction construction = constructionService.getById(ConstructionID);
        System.out.println("My message ForGeo:" + " " + constructionService.getById(ConstructionID).getName());

        /*if (construction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<>(construction, HttpStatus.OK);
    }
}
