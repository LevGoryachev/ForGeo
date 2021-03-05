package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.forgeo.models.Construction;

@Repository
public interface ConstructionRepo extends JpaRepository<Construction, Integer> {
}
