package ru.goryachev.forgeo.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.goryachev.forgeo.app.AppInit;
import ru.goryachev.forgeo.models.Location;

import java.util.List;
import java.util.Optional;

/**
 * CRUD JPA Repository testing with real DB.
 * Necessary to use Lifecycle.PER_CLASS (@TestInstance) to work with common id (testId variable).
 * An entity with autogenerated ID suppose to be created in the first method (1).
 * The ID will be used in each method (2,4,5).
 * The entity with ID suppose to be deleted in the last one (5).
 * @author Lev Goryachev
 * @version 1.0
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = AppInit.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LocationRepoTest {

    Long testId;

    @Autowired
    private LocationRepo locationRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveLocationTest(){
        Location location = new Location();
        location.setLat(12345.12345);
        location.setLng(6789.6789);
        this.testId = locationRepo.save(location).getId();
        Assertions.assertThat(location.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getLocationTest(){
        Location location = locationRepo.findById(testId).get();
        Assertions.assertThat(location.getId()).isEqualTo(testId);
    }

    @Test
    @Order(3)
    public void getAllLocationsTest(){
        List<Location> locations = locationRepo.findAll();
        Assertions.assertThat(locations.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateLocationTest(){
        Location location = locationRepo.findById(testId).get();
        location.setLng(1000.12345);
        Location locationUpdated =  locationRepo.save(location);
        Assertions.assertThat(locationUpdated.getLng()).isEqualTo(1000.12345);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteLocationTest(){
        Location location = locationRepo.findById(testId).get();
        locationRepo.delete(location);
        Location locationEmpty = null;
        Optional<Location> optionalLocation = locationRepo.findById(testId);

        if(optionalLocation.isPresent()){
            locationEmpty = optionalLocation.get();
        }
        Assertions.assertThat(locationEmpty).isNull();
    }
}