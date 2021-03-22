package ru.goryachev.forgeo.controllers.v2api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

        /*if (construction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<>(construction, HttpStatus.OK);
    }

    @RequestMapping (value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Construction> createConstruction (@RequestBody @Validated Construction construction) {

        HttpHeaders httpHeaders = new HttpHeaders();

        constructionService.create(construction);

        return new ResponseEntity<>(construction, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping (value = "{id}/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Construction> updateConstruction (@PathVariable ("id") int ConstructionID, @RequestBody @Validated Construction modifiedConstruction) {

        HttpHeaders httpHeaders = new HttpHeaders();

        constructionService.update(ConstructionID, modifiedConstruction);

        return new ResponseEntity<>(modifiedConstruction, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping (value = "{id}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Construction> deleteConstruction (@PathVariable ("id") int ConstructionID) {

        constructionService.delete(ConstructionID);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
