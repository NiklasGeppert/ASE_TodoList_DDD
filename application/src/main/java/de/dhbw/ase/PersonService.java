package de.dhbw.ase;

import de.dhbw.ase.entities.Person;
import de.dhbw.ase.exceptions.PersonNotFoundException;
import de.dhbw.ase.mappers.PersonMapper;
import de.dhbw.ase.repositories.PersonRepository;
import de.dhbw.ase.representation.PersonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private static final String NotFoundMessage = "Person not found";

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonRepresentation createPerson(PersonRepresentation personRepresentation) {
        Person person = new Person(personRepresentation.getId(),
                personRepresentation.getName(),
                personRepresentation.getemail(),
                personRepresentation.getGender()
        );

        return personMapper.toPersonRepresentation(personRepository.insert(person));
    }

    public void deletePerson(UUID id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if(optionalPerson.isEmpty()) {
            throw new PersonNotFoundException(NotFoundMessage);
        }
        personRepository.deleteById(id);
    }

    public PersonRepresentation updatePerson(UUID id, PersonRepresentation personRepresentation) {
        Person person = getPerson(id);
        person.setName(personRepresentation.getName());
        person.setEmail(personRepresentation.getemail());
        person.setGender(personRepresentation.getGender());

        return personMapper.toPersonRepresentation(personRepository.save(person));
    }

    public Person getPerson(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException(NotFoundMessage));
    }

    public List<PersonRepresentation> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return personMapper.toPersonRepresentationList(persons);
    }

    public PersonRepresentation getById(UUID id) throws PersonNotFoundException {
        return personMapper.toPersonRepresentation(personRepository
                .findById(id).orElseThrow(() ->
                        new PersonNotFoundException(NotFoundMessage)));
    }
}
