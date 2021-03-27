package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.repositories.LocationRepo;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public List<Location> getAll() {

        return locationRepo.findAll();
    }

    public Location getById(Long id) {

        return locationRepo.findById(id).get();
    }

    public Location getByName(String name) {
        return null;
    }

    public void create(Location location) {
        locationRepo.save(location);
    }

    public void update(Long locationID, Location modifiedLocation) {

        Location location = locationRepo.findById(locationID).get();
        location.setLng(modifiedLocation.getLng());
        location.setLat(modifiedLocation.getLat());
        location.setPostalAddr(modifiedLocation.getPostalAddr());
        location.setConstrAddr(modifiedLocation.getConstrAddr());
        location.setLinear(modifiedLocation.getLinear());
        locationRepo.save(location);
    }

    public void delete(Long id) {
        locationRepo.deleteById(id);
    }
}
