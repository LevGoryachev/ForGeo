package ru.goryachev.forgeo.controllers.v3api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.forgeo.exceptions.EmptyListException;
import ru.goryachev.forgeo.exceptions.EntityNotFoundException;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.services.LocationService;
import javax.validation.Valid;
import java.util.List;

/**
 * ForGeo API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 3
 */

@RestController
@RequestMapping("/api/v3/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getAllLocations () throws EmptyListException {
        List <Location> locations = locationService.getAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getLocation (@PathVariable("id") Long locationID) throws EntityNotFoundException {
        Location location = locationService.getById(locationID);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> createLocation (@RequestBody @Valid Location location) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(locationService.create(location), httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping (method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> updateLocation (@RequestBody @Valid Location modifiedLocation) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(locationService.update(modifiedLocation), httpHeaders, HttpStatus.OK);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> deleteLocation (@PathVariable ("id") Long locationID) {
        locationService.delete(locationID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<Object> handleEmptyListException(EmptyListException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return new ResponseEntity<>(e.getMostSpecificCause().getMessage(), HttpStatus.BAD_REQUEST);
    }
}
