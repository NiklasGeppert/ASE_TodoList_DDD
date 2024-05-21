package de.dhbw.ase.plugins.persistence.Person;

import de.dhbw.ase.Person.Person;
import de.dhbw.ase.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PersonRepositoryBridge implements PersonRepository {
    private final PersonData personData;

    @Autowired
    public PersonRepositoryBridge(PersonData personData){
        this.personData = personData;
    }

    @Override
    public Person save(Person person) {
        return personData.save(person);
    }

    @Override
    public Optional<Person> findById(UUID id) {
        return personData.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personData.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        personData.deleteById(id);
    }

    @Override
    public Person insert(Person person) {
        return personData.save(person);
    }
}
