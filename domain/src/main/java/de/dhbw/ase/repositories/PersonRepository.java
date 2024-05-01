package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(UUID id);
    List<Person> findAll();
    void deleteById(UUID id);
    Person insert(Person person);
}
