package ru.goryachev.forgeo.services;

import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.models.Location;
import java.util.List;

@Service
public class LocationService {

    //@Autowired
    //private LocationRepo locationRepo;

    public List<Location> getAll() {
        return null;
    }

    public Location getById(int id) {
        return null;
    }

    public Location getByName(String name) {
        return null;
    }

    public void create(Location location) {
        //locationRepo.save(location);
    }

    public void update(Location location) {

    }

    public void delete(int id) {
        //locationRepo.deleteById(id);
    }
}
