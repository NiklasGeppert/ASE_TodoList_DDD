package de.dhbw.ase.plugins.persistence;


import de.dhbw.ase.entities.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PersonRepositoryData extends MongoRepository<Person, UUID> {
}
