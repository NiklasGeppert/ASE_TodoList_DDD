package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.representation.TodoListRepresentation;
import de.dhbw.ase.values.ListStatus;
import de.dhbw.ase.entities.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoListMapperMockTest {

    private TodoListMapper todoListMapper;

    @BeforeEach
    void setUp() {
        todoListMapper = new TodoListMapper();
    }

    @Test
    void toTodoListRepresentation_ValidTodoList_ReturnsTodoListRepresentation() {
        // Arrange
        UUID personId = UUID.randomUUID();
        List<Todo> todos = Arrays.asList(
                new Todo(), new Todo() //
        );
        ListStatus listStatus = ListStatus.EMPTY;

        TodoList todoList = new TodoList();
        todoList.setPersonID(personId);
        todoList.setTodoList(todos);
        todoList.setListStatus(listStatus);

        // Act
        TodoListRepresentation result = todoListMapper.toTodoListRepresentation(todoList);

        // Assert
        assertEquals(personId, result.getPersonID());
        assertEquals(todos, result.getTodoList());
        assertEquals(listStatus, result.getListStatus());
    }
}
