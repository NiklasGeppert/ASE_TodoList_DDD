package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.TodoListService;
import de.dhbw.ase.TodoService;
import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.TodoList.TodoList;
import de.dhbw.ase.TodoList.TodoListRepresentation;
import de.dhbw.ase.values.ListStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TodoListControllerUT {

    @Mock
    TodoListService todoListService;

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoListController todoListController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(todoListController).build();
    }

    @Test
    void createTodoList() throws Exception {
        TodoListRepresentation todoListRepresentation = new TodoListRepresentation();
        when(todoListService.createTodoList(any(TodoListRepresentation.class))).thenReturn(new TodoListRepresentation());

        mockMvc.perform(post("/todoList/createTodoList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todoListRepresentation)))
                .andExpect(status().isCreated());
    }

    @Test
    void getTodoListByPersonId() throws Exception {
        UUID personID = UUID.randomUUID();
        TodoList todoList = new TodoList();
        todoList.setPersonID(personID); // Set the personID for the todoList

        when(todoListService.getTodoListByPerson(any(UUID.class))).thenReturn(todoList);

        mockMvc.perform(get("/todoList/getListByPersonId").param("personID", personID.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personID").value(personID.toString()));
    }


    @Test
    void getTodoListsByStatus() throws Exception {
        ListStatus status = ListStatus.EMPTY;
        List<TodoList> todoLists = Arrays.asList(new TodoList(), new TodoList());
        when(todoListService.getTodoListByStatus(any(ListStatus.class))).thenReturn(todoLists);

        mockMvc.perform(get("/todoList/getListsByStatus").param("status", status.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(todoLists.size()));
    }

    @Test
    void addTodoToList() throws Exception {
        UUID personId = UUID.randomUUID();
        UUID todoId = UUID.randomUUID();
        Todo todo = new Todo();
        when(todoService.getTodo(any(UUID.class))).thenReturn(todo);

        mockMvc.perform(put("/todoList/addTodoToList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("personId", personId.toString())
                        .param("todoID", todoId.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTodoList() throws Exception {
        UUID personId = UUID.randomUUID();

        mockMvc.perform(delete("/todoList/{personId}", personId))
                .andExpect(status().isAccepted());
    }

    @Test
    void removeTodoFromList() throws Exception {
        UUID personId = UUID.randomUUID();
        UUID todoId = UUID.randomUUID();

        mockMvc.perform(put("/todoList/removeTodoToList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("personId", personId.toString())
                        .param("todoID", todoId.toString()))
                .andExpect(status().isOk());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}