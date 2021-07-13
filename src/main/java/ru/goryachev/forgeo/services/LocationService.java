package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.exceptions.EmptyListException;
import ru.goryachev.forgeo.models.Address;
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

    public Location getById(Long id) {

        return locationRepo.findById(id).get();
    }

    public Location create(Location location) {
        return locationRepo.save(location);
    }

    public Location update(Location modifiedLocation) {
        return locationRepo.save(modifiedLocation);
    }

    public void delete(Long id) {
        locationRepo.deleteById(id);
    }
}
