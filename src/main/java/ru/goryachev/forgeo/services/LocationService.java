package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.repositories.LocationRepo;

import java.util.List;

public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public List<Location> getAll() {
        return locationRepo.findAll();
    }

    public Location getById(int id) {
        return locationRepo.getOne(id);
    }

    public Location getByName(String name) {
        return null;
    }

    public void create(Location location) {
        locationRepo.save(location);
    }

    public void update(Location location) {

    }

    public void delete(int id) {
        locationRepo.deleteById(id);
    }
}
