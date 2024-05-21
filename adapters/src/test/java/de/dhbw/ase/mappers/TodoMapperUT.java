package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.representation.TodoRepresentation;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TodoMapperUT {

    private TodoMapper todoMapper;

    @BeforeEach
    void setUp() {
        todoMapper = new TodoMapper();
    }

    @Test
    void toTodoRepresentation_ValidTodo_ReturnsTodoRepresentation() {
        // Arrange
        Todo todo = new Todo();
        todo.setTitle("Test Title");
        todo.setDescription("Test Description");
        todo.setStatus(Status.OPEN);
        todo.setendDate(new EndDate(LocalDate.now()));
        todo.setPersonID(UUID.randomUUID());

        // Act
        TodoRepresentation result = todoMapper.toTodoRepresentation(todo);

        // Assert
        assertNotNull(result);
        assertEquals(todo.getTodoID(), result.getId());
        assertEquals(todo.getTitle(), result.getTitle());
        assertEquals(todo.getDescription(), result.getDescription());
        assertEquals(todo.getStatus(), result.getStatus());
        assertEquals(todo.getendDate(), result.getEnddate());
        assertEquals(todo.getPersonID(), result.getPersonID());
    }

    @Test
    void toTodoRepresentation_NullTodo_ReturnsNull() {
        // Arrange
        Todo todo = null;

        // Act
        TodoRepresentation result = todoMapper.toTodoRepresentation(todo);

        // Assert
        assertNull(result);
    }
}
