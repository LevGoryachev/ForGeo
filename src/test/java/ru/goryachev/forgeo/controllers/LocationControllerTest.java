package ru.goryachev.forgeo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.goryachev.forgeo.app.AppInit;
import ru.goryachev.forgeo.controllers.v3api.LocationController;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.models.Location;
import ru.goryachev.forgeo.security.SmallCORSFilter;
import ru.goryachev.forgeo.services.LocationService;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * CRUD API-layer testing using mocks.
 * Each method in different object (Lifecycle.PER_METHOD)
 * @author Lev Goryachev
 * @version 1.0
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = AppInit.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private SmallCORSFilter smallCORSFilter;
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @MockBean
    private LocationService locationService;

    @InjectMocks
    private LocationController locationController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        /*mockMvc = MockMvcBuilders
                .standaloneSetup(locationController)
                //.addFilters(smallCORSFilter)
                //.addFilters(new CorsFilter())
                .build();*/
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void createLocationTest() throws Exception{
        Location location = new Location();
        location.setId(1L);
        location.setLat(12345.12345);
        location.setLng(6789.6789);

        String jsonLocation = asJsonString(location);

        when(locationService.create(location)).thenReturn(location);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v3/locations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonLocation))
                //.andExpect(MockMvcResultMatchers.model().attributeExists("lineOne"))
                .andExpect(MockMvcResultMatchers.content().json(jsonLocation));
                //.andExpect(status().isCreated());

        String s = mvcResult.andReturn().getResponse().getContentAsString();
    }

    @Test
    @Order(2)
    public void getLocationTest() throws Exception {
        Location location = new Location();
        location.setId(2L);
        location.setLat(12345.12345);
        location.setLng(6789.6789);

        String jsonLocation = asJsonString(location);

        when(locationService.getById(2L)).thenReturn(location);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v3/locations/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonLocation))
                .andExpect(MockMvcResultMatchers.content().json(jsonLocation));
    }

    @Test
    @Order(3)
    public void getAllLocationsTest() throws Exception {
        List<Location> locations = new ArrayList<>();
        for (Integer i = 1; i < 5; i++){
            Location location = new Location();
            location.setId(i.longValue());
            location.setLat(12345.12345 + i.doubleValue());
            location.setLng(6789.6789 + i.doubleValue());
            locations.add(location);
        }

        String jsonLocations = asJsonString(locations);

        when(locationService.getAll()).thenReturn(locations);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v3/locations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonLocations))
                .andExpect(MockMvcResultMatchers.content().json(jsonLocations));
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateLocationTest() throws Exception{
        Location location = new Location();
        location.setId(4L);
        location.setLat(12345.12345);
        location.setLng(6789.6789);
        String jsonLocation = asJsonString(location);

        when(locationService.update(location)).thenReturn(location);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v3/locations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonLocation))
                .andExpect(MockMvcResultMatchers.content().json(jsonLocation));
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteLocationTest() throws Exception {
        Long testId = 2L;

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/v3/locations/2"));
        verify(locationService).delete(testId);
    }
}