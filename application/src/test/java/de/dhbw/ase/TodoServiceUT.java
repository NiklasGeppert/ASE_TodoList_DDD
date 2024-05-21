package de.dhbw.ase;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.mappers.TodoMapper;
import de.dhbw.ase.representation.TodoRepresentation;
import de.dhbw.ase.repositories.TodoRepository;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TodoServiceUT {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private TodoMapper todoMapper;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTodo_ValidRepresentation_ReturnsTodoRepresentation() {
        TodoRepresentation representation = new TodoRepresentation();
        representation.setTitle("Test Todo");
        representation.setDescription("Test Description");
        representation.setEnddate(new EndDate(LocalDate.now()));
        representation.setPersonID(UUID.randomUUID());

        Todo savedTodo = new Todo();
        savedTodo.setTitle(representation.getTitle());
        savedTodo.setDescription(representation.getDescription());
        savedTodo.setendDate((representation.getEnddate()));
        savedTodo.setPersonID(representation.getPersonID());

        when(todoRepository.save(any(Todo.class))).thenReturn(savedTodo);

        TodoRepresentation mappedRepresentation = new TodoRepresentation();
        mappedRepresentation.setTitle(savedTodo.getTitle());
        mappedRepresentation.setDescription(savedTodo.getDescription());
        mappedRepresentation.setEnddate(savedTodo.getendDate());
        mappedRepresentation.setPersonID(savedTodo.getPersonID());

        when(todoMapper.toTodoRepresentation(any(Todo.class))).thenReturn(mappedRepresentation);

        TodoRepresentation result = todoService.createTodo(representation);

        assertNotNull(result);
        assertEquals(representation.getTitle(), result.getTitle());
        assertEquals(representation.getDescription(), result.getDescription());
        assertEquals(representation.getEnddate(), result.getEnddate());
        assertEquals(representation.getPersonID(), result.getPersonID());
    }

    @Test
    void getAllPersonsTodos_ReturnsTodos() {
        UUID personId = UUID.randomUUID();
        List<Todo> todos = List.of(new Todo(), new Todo());

        when(todoRepository.findByPerson(personId)).thenReturn(todos);

        List<Todo> result = todoService.getAllPersonsTodos(personId);

        assertNotNull(result);
        assertEquals(todos.size(), result.size());
    }

    @Test
    void getByEnddate_ValidDate_ReturnsTodos() {
        String enddateString = "2024-12-31";
        EndDate enddate = new EndDate(LocalDate.of(2024, 12, 31));
        List<Todo> todos = List.of(new Todo(), new Todo());

        when(todoRepository.findByEnddate(enddate)).thenReturn(todos);

        List<Todo> result = todoService.getByEnddate(enddateString);

        assertNotNull(result);
        assertEquals(todos.size(), result.size());
    }

    @Test
    void getByEnddate_InvalidDate_ThrowsException() {
        String enddateString = "invalid-date";

        assertThrows(IllegalArgumentException.class, () -> todoService.getByEnddate(enddateString));
    }

    @Test
    void getByStatus_ReturnsTodos() {
        Status status = Status.OPEN;
        List<Todo> todos = List.of(new Todo(), new Todo());

        when(todoRepository.findByStatus(status)).thenReturn(todos);

        List<Todo> result = todoService.getByStatus(status);

        assertNotNull(result);
        assertEquals(todos.size(), result.size());
    }

    @Test
    void changePerson_ExistingTodo_ChangesPersonID() {
        UUID todoId = UUID.randomUUID();
        UUID personId = UUID.randomUUID();
        Todo todo = new Todo();

        when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));

        todoService.changePerson(todoId, personId);

        assertEquals(personId, todo.getPersonID());
    }
}
