package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.forgeo.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
