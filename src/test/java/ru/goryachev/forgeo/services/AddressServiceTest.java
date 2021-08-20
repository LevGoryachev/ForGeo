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
import ru.goryachev.forgeo.models.Address;
import ru.goryachev.forgeo.repositories.AddressRepo;

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
public class AddressServiceTest {

    @InjectMocks
    AddressService addressService;

    @Mock
    private AddressRepo addressRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void createAddressTest(){
        Address address = new Address();
        address.setId(1L);
        address.setType("testValueType");
        address.setLineOne("testValueAbc");
        address.setLineTwo("testValueDef");
        address.setLineThree("testValueXyz");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");
        when(addressRepo.save(address)).thenReturn(address);
        Address savedAddress = addressService.create(address);
        Assertions.assertThat(savedAddress.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getAddressTest() throws EntityNotFoundException {
        Address address = new Address();
        address.setId(2L);
        address.setType("testValueType");
        address.setLineOne("testValueAbc");
        address.setLineTwo("testValueDef");
        address.setLineThree("testValueXyz");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");
        when(addressRepo.findById(2L)).thenReturn(Optional.of(address));
        Address addressRead = addressService.getById(2L);
        Assertions.assertThat(addressRead.getId()).isEqualTo(2L);
    }

    @Test
    @Order(3)
    public void getAllAddresssTest() throws EmptyListException {
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
        when(addressRepo.findAll()).thenReturn(addresses);
        List<Address> addressesRead = addressService.getAll(null);
        Assertions.assertThat(addressesRead.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateAddressTest(){
        Address address = new Address();
        address.setId(1L);
        address.setType("testValueType");
        address.setLineOne("testValueAbc");
        address.setLineTwo("testValueDef");
        address.setLineThree("testValueXyz");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");
        when(addressRepo.save(address)).thenReturn(address);
        Address savedAddress = addressService.update(address);
        Assertions.assertThat(savedAddress.getLineOne()).isEqualTo("testValueAbc");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteAddressTest(){
        Long testId = 2L;
        addressService.delete(testId);
        verify(addressRepo).deleteById(testId);
    }
}