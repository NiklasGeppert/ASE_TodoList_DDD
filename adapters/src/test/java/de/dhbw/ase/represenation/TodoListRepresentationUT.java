package de.dhbw.ase.represenation;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.representation.TodoListRepresentation;
import de.dhbw.ase.values.ListStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TodoListRepresentationUT {

    @Test
    void constructor_WithParameters_CreatesInstanceWithSpecifiedValues() {
        // Arrange
        UUID personId = UUID.randomUUID();
        List<Todo> todoList = new ArrayList<>();
        ListStatus listStatus = ListStatus.EMPTY;

        // Act
        TodoListRepresentation todoListRepresentation = new TodoListRepresentation(personId, todoList, listStatus);

        // Assert
        assertEquals(personId, todoListRepresentation.getPersonID());
        assertEquals(todoList, todoListRepresentation.getTodoList());
        assertEquals(listStatus, todoListRepresentation.getListStatus());
    }

    @Test
    void getters_ReturnCorrectValues() {
        // Arrange
        UUID personId = UUID.randomUUID();
        List<Todo> todoList = new ArrayList<>();
        ListStatus listStatus = ListStatus.EMPTY;
        TodoListRepresentation todoListRepresentation = new TodoListRepresentation(personId, todoList, listStatus);

        // Assert
        assertEquals(personId, todoListRepresentation.getPersonID());
        assertEquals(todoList, todoListRepresentation.getTodoList());
        assertEquals(listStatus, todoListRepresentation.getListStatus());
    }

    @Test
    void defaultConstructor_CreatesInstance() {
        // Act
        TodoListRepresentation todoListRepresentation = new TodoListRepresentation();

        // Assert
        assertNotNull(todoListRepresentation);
    }
}
