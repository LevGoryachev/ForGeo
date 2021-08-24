package ru.goryachev.forgeo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ru.goryachev.forgeo.app.AppInit;
import ru.goryachev.forgeo.exceptions.EmptyListException;
import ru.goryachev.forgeo.exceptions.EntityNotFoundException;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.repositories.LocationRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * CRUD service-layer testing using mocks.
 * Each method in different object (Lifecycle.PER_METHOD)
 * @author Lev Goryachev
 * @version 1.0
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = AppInit.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LocationServiceTest {

    @InjectMocks
    private LocationService locationService;

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

    @Test
    @Order(2)
    public void getLocationTest() throws EntityNotFoundException {
        Location location = new Location();
        location.setId(2L);
        location.setLat(12345.12345);
        location.setLng(6789.6789);
        when(locationRepo.findById(2L)).thenReturn(Optional.of(location));
        Location locationRead = locationService.getById(2L);
        Assertions.assertThat(locationRead.getId()).isEqualTo(2L);
    }

    @Test
    @Order(3)
    public void getAllLocationsTest() throws EmptyListException {
        List<Location> locations = new ArrayList<>();
        for (Integer i = 1; i < 5; i++){
            Location location = new Location();
            location.setId(i.longValue());
            location.setLat(12345.12345 + i.doubleValue());
            location.setLng(6789.6789 + i.doubleValue());
            locations.add(location);
        }
        when(locationRepo.findAll()).thenReturn(locations);
        List<Location> locationsRead = locationService.getAll();
        Assertions.assertThat(locationsRead.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateLocationTest(){
        Location location = new Location();
        location.setId(3L);
        location.setLat(12345.12345);
        location.setLng(6789.6789);
        when(locationRepo.save(location)).thenReturn(location);
        Location savedLocation = locationService.update(location);
        Assertions.assertThat(savedLocation.getLng()).isEqualTo(6789.6789);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteLocationTest(){
        Long testId = 2L;
        locationService.delete(testId);
        verify(locationRepo).deleteById(testId);
    }
}