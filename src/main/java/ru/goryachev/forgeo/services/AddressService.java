package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.exceptions.EmptyListException;
import ru.goryachev.forgeo.exceptions.EntityNotFoundException;
import ru.goryachev.forgeo.models.Address;
import ru.goryachev.forgeo.repositories.AddressRepo;
import ru.goryachev.forgeo.repositories.LocationRepo;

import java.util.List;

/**
 * AddressService provides CRUD operations for Address.
 * @author Lev Goryachev
 * @version 3
 */

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    private LocationRepo locationRepo;

    public List<Address> getAll(String type) throws EmptyListException {
        if (type == null) {
            List<Address> allAddresses = addressRepo.findAll();
            if (allAddresses.isEmpty()) {
                throw new EmptyListException();
            }
            return allAddresses;
        }
        List<Address> allAddresses = addressRepo.findAllByType(type);
        if (allAddresses.isEmpty()) {
            throw new EmptyListException();
        }
        return allAddresses;
    }

    public Address getById(Long id) throws EntityNotFoundException {
        Address address = addressRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return address;
    }

    public Address create(Address address) {

        return addressRepo.save(address);
    }

    public Address update(Address modifiedAddress) {
        return addressRepo.save(modifiedAddress);
    }

    public void delete(Long id) {
        addressRepo.deleteById(id);
    }
}
