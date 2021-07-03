package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.models.Address;
import ru.goryachev.forgeo.repositories.AddressRepo;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    public List<Address> getAllByType(String type) {
        return addressRepo.findAllByType(type);
    }

    public Address getById(Long id) {
        return addressRepo.findById(id).get();
    }

    public void create(Address address) {
        addressRepo.save(address);
    }

    public void update(Address modifiedAddress) {
        addressRepo.save(modifiedAddress);
    }

    public void delete(Long id) {
        addressRepo.deleteById(id);
    }
}
