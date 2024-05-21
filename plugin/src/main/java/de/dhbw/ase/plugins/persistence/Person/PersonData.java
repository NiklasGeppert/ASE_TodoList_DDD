package de.dhbw.ase.plugins.persistence.Person;

import de.dhbw.ase.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonData extends JpaRepository<Person, UUID> {
}
