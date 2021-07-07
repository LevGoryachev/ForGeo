package ru.goryachev.forgeo.controllers.v3api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.forgeo.models.Address;
import ru.goryachev.forgeo.services.AddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v3/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> getAllAddresses (@RequestParam(value = "type", required = false) String type) {
        List <Address> addresses = addressService.getAll(type);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> getAddress (@PathVariable("id") Long addressID) {
        Address address = addressService.getById(addressID);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> createAddress (@RequestBody @Valid Address address) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(addressService.create(address), httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping (method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> updateAddress (@RequestBody @Valid Address modifiedAddress) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(addressService.update(modifiedAddress), httpHeaders, HttpStatus.OK);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> deleteAddress (@PathVariable ("id") Long addressID) {
        addressService.delete(addressID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
