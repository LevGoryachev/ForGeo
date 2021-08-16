package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.exceptions.EmptyListException;
import ru.goryachev.forgeo.exceptions.EntityNotFoundException;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.repositories.LocationRepo;

import java.util.List;

/**
 * LocationService provides CRUD operations for Location.
 * @author Lev Goryachev
 * @version 3
 */

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public List<Location> getAll() throws EmptyListException {

        List<Location> allLocations =  locationRepo.findAll();
        if (allLocations.isEmpty()) {
            throw new EmptyListException();
        }
        return allLocations;
    }

    public Location getById(Long id) throws EntityNotFoundException {
        Location location = locationRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return location;
    }

    public Location create(Location location) {

        Location location1 = locationRepo.save(location);
        Long x = location1.getId();
        return location1;
    }

    public Location update(Location modifiedLocation) {
        return locationRepo.save(modifiedLocation);
    }

    public void delete(Long id) {
        locationRepo.deleteById(id);
    }
}
