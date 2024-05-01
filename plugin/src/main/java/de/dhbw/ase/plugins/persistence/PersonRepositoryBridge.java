package de.dhbw.ase.plugins.persistence;

import de.dhbw.ase.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryBridge implements PersonRepository {
    private final PersonRepositoryData personRepositoryData;

    @Autowired
    public PersonRepositoryBridge(final PersonRepositoryData personRepositoryData) {
        this.personRepositoryData = personRepositoryData;
    }
}
