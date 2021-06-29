package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionRepo extends JpaRepository<Construction, Long> {
}
