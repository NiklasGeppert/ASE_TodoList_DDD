package de.dhbw.ase.represenation;

import de.dhbw.ase.Todo.TodoRepresentation;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TodoRepresentationUT {

    @Test
    void constructor_WithParameters_CreatesInstanceWithSpecifiedValues() {
        // Arrange
        UUID id = UUID.randomUUID();
        String title = "Test Todo";
        String description = "Test Description";
        Status status = Status.IN_PROGRESS;
        EndDate endDate = new EndDate(LocalDate.now());
        UUID personId = UUID.randomUUID();

        // Act
        TodoRepresentation todoRepresentation = new TodoRepresentation(id, title, description, status, endDate, personId);

        // Assert
        assertEquals(id, todoRepresentation.getId());
        assertEquals(title, todoRepresentation.getTitle());
        assertEquals(description, todoRepresentation.getDescription());
        assertEquals(status, todoRepresentation.getStatus());
        assertEquals(endDate, todoRepresentation.getEnddate());
        assertEquals(personId, todoRepresentation.getPersonID());
    }

    @Test
    void gettersAndSetters_ReturnCorrectValues() {
        // Arrange
        TodoRepresentation todoRepresentation = new TodoRepresentation();
        UUID id = UUID.randomUUID();
        String title = "Test Todo";
        String description = "Test Description";
        Status status = Status.IN_PROGRESS;
        EndDate endDate = new EndDate(LocalDate.now());
        UUID personId = UUID.randomUUID();

        // Act
        todoRepresentation.setId(id);
        todoRepresentation.setTitle(title);
        todoRepresentation.setDescription(description);
        todoRepresentation.setStatus(status);
        todoRepresentation.setEnddate(endDate);
        todoRepresentation.setPersonID(personId);

        // Assert
        assertEquals(id, todoRepresentation.getId());
        assertEquals(title, todoRepresentation.getTitle());
        assertEquals(description, todoRepresentation.getDescription());
        assertEquals(status, todoRepresentation.getStatus());
        assertEquals(endDate, todoRepresentation.getEnddate());
        assertEquals(personId, todoRepresentation.getPersonID());
    }

    @Test
    void defaultConstructor_CreatesInstance() {
        // Act
        TodoRepresentation todoRepresentation = new TodoRepresentation();

        // Assert
        assertNotNull(todoRepresentation);
    }
}
