package de.dhbw.ase;

import de.dhbw.ase.Person.Person;
import de.dhbw.ase.Person.PersonNotFoundException;
import de.dhbw.ase.Person.PersonMapper;
import de.dhbw.ase.Person.PersonRepository;
import de.dhbw.ase.Person.PersonRepresentation;
import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonServiceUT {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    private Person person;
    private PersonRepresentation personRepresentation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        UUID personId = UUID.randomUUID();
        person = new Person(personId, new PersonName("Doe", "John"), new Email("john.doe@example.com"), Gender.MALE);
        personRepresentation = new PersonRepresentation(personId, new PersonName("Doe", "John"), new Email("john.doe@example.com"), Gender.MALE);
    }

    @Test
    void createPerson() {
        when(personRepository.insert(any(Person.class))).thenReturn(person);
        when(personMapper.toPersonRepresentation(any(Person.class))).thenReturn(personRepresentation);

        PersonRepresentation result = personService.createPerson(personRepresentation);

        assertNotNull(result);
        assertEquals(personRepresentation.getId(), result.getId());
        verify(personRepository, times(1)).insert(any(Person.class));
    }

    @Test
    void deletePerson() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));

        personService.deletePerson(person.getId());

        verify(personRepository, times(1)).deleteById(person.getId());
    }

    @Test
    void deletePerson_NotFound() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> personService.deletePerson(person.getId()));
    }

    @Test
    void updatePerson() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));
        when(personRepository.save(any(Person.class))).thenReturn(person);
        when(personMapper.toPersonRepresentation(any(Person.class))).thenReturn(personRepresentation);

        PersonRepresentation result = personService.updatePerson(person.getId(), personRepresentation);

        assertNotNull(result);
        assertEquals(personRepresentation.getName(), result.getName());
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void getPerson() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));

        Person result = personService.getPerson(person.getId());

        assertNotNull(result);
        assertEquals(person.getId(), result.getId());
        verify(personRepository, times(1)).findById(person.getId());
    }

    @Test
    void getPerson_NotFound() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> personService.getPerson(person.getId()));
    }

    @Test
    void getAllPersons() {
        when(personRepository.findAll()).thenReturn(Arrays.asList(person));
        when(personMapper.toPersonRepresentationList(anyList())).thenReturn(Arrays.asList(personRepresentation));

        var result = personService.getAllPersons();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void getById() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));
        when(personMapper.toPersonRepresentation(any(Person.class))).thenReturn(personRepresentation);

        PersonRepresentation result = personService.getById(person.getId());

        assertNotNull(result);
        assertEquals(personRepresentation.getId(), result.getId());
        verify(personRepository, times(1)).findById(person.getId());
    }

    @Test
    void getById_NotFound() {
        when(personRepository.findById(person.getId())).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> personService.getById(person.getId()));
    }
}
