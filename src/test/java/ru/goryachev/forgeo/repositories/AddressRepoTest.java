package ru.goryachev.forgeo.repositories;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import ru.goryachev.forgeo.app.AppInit;
import ru.goryachev.forgeo.models.Address;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Import(AppInit.class)
//@Component
@SpringBootTest(classes = AppInit.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressRepoTest {

    @Autowired
    private AddressRepo addressRepo;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

        /*Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();*/
        Address address = new Address();
        address.setType("postal");
        address.setLineOne("abc");
        address.setLineTwo("def");
        address.setLineThree("ghi");
        address.setTownCity("Los Angeles");
        address.setCountry("USA");
        address.setZipPostal("115588");

        addressRepo.save(address);

        Assertions.assertThat(address.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Address address = addressRepo.findById(1L).get();

        Assertions.assertThat(address.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfEmployeesTest(){

        List<Address> addresses = addressRepo.findAll();

        Assertions.assertThat(addresses.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Address address = addressRepo.findById(1L).get();

        address.setCountry("BananaRepublic");

        Address addressUpdated =  addressRepo.save(address);

        Assertions.assertThat(addressUpdated.getCountry()).isEqualTo("BananaRepublic");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Address address = addressRepo.findById(1L).get();

        addressRepo.delete(address);

        //employeeRepository.deleteById(1L);

        Address address1 = null;

        //Optional<Employee> optionalEmployee = employeeRepository.findByEmail("ram@gmail.com");

        /*if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }*/

        Assertions.assertThat(address1).isNull();
    }
}