package de.dhbw.ase.represenation;

import de.dhbw.ase.representation.PersonRepresentation;
import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonRepresentationUT {

    @Test
    void constructor_WithIdAndParameters_CreatesInstanceWithSpecifiedValues() {
        // Arrange
        UUID id = UUID.randomUUID();
        PersonName name = new PersonName("Doe", "John");
        Email email = new Email("john@example.com");
        Gender gender = Gender.MALE;

        // Act
        PersonRepresentation person = new PersonRepresentation(id, name, email, gender);

        // Assert
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(email, person.getemail());
        assertEquals(gender, person.getGender());
    }

    @Test
    void constructor_WithParameters_CreatesInstanceWithGeneratedId() {
        // Arrange
        PersonName name = new PersonName("Doe", "John");
        Email email = new Email("john@example.com");
        Gender gender = Gender.MALE;

        // Act
        PersonRepresentation person = new PersonRepresentation(name, email, gender);

        // Assert
        assertNotNull(person.getId());
        assertEquals(name, person.getName());
        assertEquals(email, person.getemail());
        assertEquals(gender, person.getGender());
    }

    @Test
    void getters_ReturnCorrectValues() {
        // Arrange
        UUID id = UUID.randomUUID();
        PersonName name = new PersonName("Doe", "John");
        Email email = new Email("john@example.com");
        Gender gender = Gender.MALE;
        PersonRepresentation person = new PersonRepresentation(id, name, email, gender);

        // Assert
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(email, person.getemail());
        assertEquals(gender, person.getGender());
    }
}
