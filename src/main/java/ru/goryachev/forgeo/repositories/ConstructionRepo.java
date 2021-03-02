package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goryachev.forgeo.models.Construction;

public interface ConstructionRepo extends JpaRepository<Construction, Integer> {
}
