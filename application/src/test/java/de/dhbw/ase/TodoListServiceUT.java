package de.dhbw.ase;

import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.TodoList.TodoList;
import de.dhbw.ase.TodoList.TodoListNotFoundException;
import de.dhbw.ase.TodoList.TodoListMapper;
import de.dhbw.ase.TodoList.TodoListRepository;
import de.dhbw.ase.TodoList.TodoListRepresentation;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.ListStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TodoListServiceUT {

    @Mock
    private TodoListRepository todoListRepository;

    @Mock
    private TodoListMapper todoListMapper;

    @InjectMocks
    private TodoListService todoListService;

    private TodoList todoList;
    private Todo todo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        UUID personID = UUID.randomUUID();
        todoList = new TodoList(personID, Arrays.asList(), ListStatus.EMPTY);
        todo = new Todo("sample todo", "sample todo description", new EndDate(LocalDate.now().plusDays(new Random().nextInt(30))),UUID.randomUUID());

        when(todoListRepository.findById(personID)).thenReturn(Optional.of(todoList));
    }

    @Test
    void createTodoList() {
        TodoListRepresentation todoListRepresentation = new TodoListRepresentation(todoList.getPersonID(), todoList.getTodoList(), todoList.getListStatus());
        when(todoListRepository.save(any(TodoList.class))).thenReturn(todoList);
        when(todoListMapper.toTodoListRepresentation(any(TodoList.class))).thenReturn(todoListRepresentation);

        TodoListRepresentation result = todoListService.createTodoList(todoListRepresentation);

        assertNotNull(result);
        assertEquals(todoList.getPersonID(), result.getPersonID());
        assertEquals(todoList.getTodoList().size(), result.getTodoList().size());
        assertEquals(todoList.getListStatus(), result.getListStatus());
        verify(todoListRepository, times(1)).save(any(TodoList.class));
    }

    @Test
    void getTodoListByPerson() {
        TodoList result = todoListService.getTodoListByPerson(todoList.getPersonID());

        assertNotNull(result);
        assertEquals(todoList, result);
        verify(todoListRepository, times(1)).findById(todoList.getPersonID());
    }

    @Test
    void getTodoListByStatus() {
        List<TodoList> todoLists = Arrays.asList(todoList);
        when(todoListRepository.findbyStatus(ListStatus.EMPTY)).thenReturn(todoLists);

        List<TodoList> result = todoListService.getTodoListByStatus(ListStatus.EMPTY);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(todoLists.size(), result.size());
        verify(todoListRepository, times(1)).findbyStatus(ListStatus.EMPTY);
    }

    @Test
    void deleteTodoListByPerson() {
        assertDoesNotThrow(() -> todoListService.deleteTodoListByPerson(todoList.getPersonID()));
        verify(todoListRepository, times(1)).delete(todoList);
    }

    @Test
    void deleteTodoListByPerson_NotFound() {
        when(todoListRepository.findById(todoList.getPersonID())).thenReturn(Optional.empty());

        assertThrows(TodoListNotFoundException.class, () -> todoListService.deleteTodoListByPerson(todoList.getPersonID()));
    }

    @Test
    void addTodo() {
        TodoList result = todoListService.addTodo(todoList.getPersonID(), todo);

        assertNotNull(result);
        assertTrue(result.getTodoList().contains(todo));
        verify(todoListRepository, times(1)).insert(todoList, todo);
    }

    @Test
    void removeTodo() {
        TodoList result = todoListService.removeTodo(todoList.getPersonID(), todo.getTodoID());

        assertNotNull(result);
        assertFalse(result.getTodoList().contains(todo));
        verify(todoListRepository, times(1)).remove(todoList, todo.getTodoID());
    }
}
