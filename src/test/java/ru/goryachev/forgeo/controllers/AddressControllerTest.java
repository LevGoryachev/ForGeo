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
import ru.goryachev.forgeo.controllers.v3api.AddressController;
import ru.goryachev.forgeo.models.Address;
import ru.goryachev.forgeo.security.SmallCORSFilter;
import ru.goryachev.forgeo.services.AddressService;

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
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private SmallCORSFilter smallCORSFilter;
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @MockBean
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        /*mockMvc = MockMvcBuilders
                .standaloneSetup(addressController)
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
    public void createAddressTest() throws Exception{
        Address address = new Address();
        address.setId(1L);
        address.setType("testValueType");
        address.setLineOne("testValueAbc");
        address.setLineTwo("testValueDef");
        address.setLineThree("testValueXyz");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");

        String jsonAddress = asJsonString(address);

        when(addressService.create(address)).thenReturn(address);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v3/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAddress))
                //.andExpect(MockMvcResultMatchers.model().attributeExists("lineOne"))
                .andExpect(MockMvcResultMatchers.content().json(jsonAddress));
                //.andExpect(status().isCreated());

        String s = mvcResult.andReturn().getResponse().getContentAsString();
    }

    @Test
    @Order(2)
    public void getAddressTest() throws Exception {
        Address address = new Address();
        address.setId(2L);
        address.setType("testValueType");
        address.setLineOne("testValueAbc");
        address.setLineTwo("testValueDef");
        address.setLineThree("testValueXyz");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");

        String jsonAddress = asJsonString(address);

        when(addressService.getById(2L)).thenReturn(address);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v3/addresses/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAddress))
                .andExpect(MockMvcResultMatchers.content().json(jsonAddress));
    }

    @Test
    @Order(3)
    public void getAllAddressesTest() throws Exception {
        List<Address> addresses = new ArrayList<>();
        for (Integer i = 1; i < 5; i++){
            Address address = new Address();
            address.setId(i.longValue());
            address.setType("testValueType");
            address.setLineOne("testValueAbc" + i);
            address.setLineTwo("testValueDef"+ i);
            address.setLineThree("testValueXyz"+ i);
            address.setTownCity("Los Angeles"+ i);
            address.setCountry("USA");
            address.setZipPostal("115588");
            addresses.add(address);
        }

        String jsonAddresses = asJsonString(addresses);

        when(addressService.getAll(null)).thenReturn(addresses);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v3/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAddresses))
                .andExpect(MockMvcResultMatchers.content().json(jsonAddresses));
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateAddressTest() throws Exception{
        Address address = new Address();
        address.setId(1L);
        address.setType("testValueType");
        address.setLineOne("testValueAbc");
        address.setLineTwo("testValueDef");
        address.setLineThree("testValueXyz");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");

        String jsonAddress = asJsonString(address);

        when(addressService.update(address)).thenReturn(address);

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v3/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAddress))
                .andExpect(MockMvcResultMatchers.content().json(jsonAddress));
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteAddressTest() throws Exception {
        Long testId = 2L;

        ResultActions mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/v3/addresses/2"));
        verify(addressService).delete(testId);
    }
}