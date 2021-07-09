package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.forgeo.models.Address;

import java.util.List;

/**
 * LocationRepo (Spring Data JPA repository) for entity Address.
 * @author Lev Goryachev
 * @version 3
 */

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    List<Address>findAllByType(String type);
}
