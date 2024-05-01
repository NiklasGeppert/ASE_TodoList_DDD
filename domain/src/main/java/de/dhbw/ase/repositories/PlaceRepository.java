package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.Place;
import org.springframework.stereotype.Repository;

public interface PlaceRepository {
    Place save(Place place);
    void delete(Place place);
    Place insert(Place place);


}
