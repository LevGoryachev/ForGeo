package ru.goryachev.forgeo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.forgeo.models.Location;

/**
 * LocationRepo (Spring Data JPA repository) for entity Location.
 * @author Lev Goryachev
 * @version 3
 */

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
}
