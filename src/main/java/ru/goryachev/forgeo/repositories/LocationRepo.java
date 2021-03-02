package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goryachev.forgeo.models.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {
}
