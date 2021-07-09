package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.models.Address;
import ru.goryachev.forgeo.repositories.AddressRepo;

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

    public List<Address> getAll(String type) {
        if (type == null) {
            return addressRepo.findAll();
        }
        return addressRepo.findAllByType(type);
    }

    public Address getById(Long id) {
        return addressRepo.findById(id).get();
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
