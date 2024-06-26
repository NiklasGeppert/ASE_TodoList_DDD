package de.dhbw.ase.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(UUID id);
    List<Person> findAll();
    void deleteById(UUID id);
    Person insert(Person person);
}
