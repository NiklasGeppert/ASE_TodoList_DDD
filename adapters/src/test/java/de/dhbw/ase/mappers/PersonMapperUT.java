package de.dhbw.ase.mappers;

import de.dhbw.ase.Person.Person;
import de.dhbw.ase.Person.PersonMapper;
import de.dhbw.ase.Person.PersonRepresentation;
import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonMapperUT {

    private PersonMapper personMapper;

    @BeforeEach
    void setUp() {
        personMapper = new PersonMapper();
    }

    @Test
    void toPersonRepresentationList_ValidPersonList_ReturnsListRepresentation() {
        // Arrange
        Person person1 = new Person(UUID.randomUUID(), new PersonName("Doe"," John"), new Email("john@example.com"), Gender.MALE);
        Person person2 = new Person(UUID.randomUUID(), new PersonName("Doe"," Jane"), new Email("jane@example.com"), Gender.FEMALE);
        List<Person> personList = Arrays.asList(person1, person2);

        // Act
        List<PersonRepresentation> result = personMapper.toPersonRepresentationList(personList);

        // Assert
        assertEquals(2, result.size());
        assertEquals(person1.getId(), result.get(0).getId());
        assertEquals(person1.getName(), result.get(0).getName());
        assertEquals(person1.geteMail(), result.get(0).getemail());
        assertEquals(person1.getGender(), result.get(0).getGender());

        assertEquals(person2.getId(), result.get(1).getId());
        assertEquals(person2.getName(), result.get(1).getName());
        assertEquals(person2.geteMail(), result.get(1).getemail());
        assertEquals(person2.getGender(), result.get(1).getGender());
    }

    @Test
    void toPersonRepresentation_ValidPerson_ReturnsRepresentation() {
        // Arrange
        UUID id = UUID.randomUUID();
        PersonName name = new PersonName("Doe", "John");
        Email email = new Email("john@example.com");
        Gender gender = Gender.MALE;
        Person person = new Person(id, name, email, gender);

        // Act
        PersonRepresentation result = personMapper.toPersonRepresentation(person);

        // Assert
        assertEquals(id, result.getId());
        assertEquals(name, result.getName());
        assertEquals(email, result.getemail());
        assertEquals(gender, result.getGender());
    }
}
