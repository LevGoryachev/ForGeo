package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.forgeo.models.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
}
