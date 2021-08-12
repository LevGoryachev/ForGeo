package ru.goryachev.forgeo.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.goryachev.forgeo.app.AppInit;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.services.LocationService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

/**
 * CRUD service-layer testing using mocks.
 * @author Lev Goryachev
 * @version 1.0
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = AppInit.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LocationServiceTest {

    @InjectMocks
    LocationService locationService;

    @Mock
    private LocationRepo locationRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void createLocationTest(){
        Location location = new Location();
        location.setId(1L);
        location.setLat(12345.12345);
        location.setLng(6789.6789);
        when(locationRepo.save(location)).thenReturn(location);
        Location savedLocation = locationService.create(location);
        Assertions.assertThat(savedLocation.getId()).isGreaterThan(0);
    }

  /*  @Test
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
    }*/
}