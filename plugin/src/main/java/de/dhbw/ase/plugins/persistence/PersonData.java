package de.dhbw.ase.plugins.persistence;

import de.dhbw.ase.entities.Person;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import java.util.UUID;

public interface PersonData extends JpaRepository<Person, UUID> {
}
