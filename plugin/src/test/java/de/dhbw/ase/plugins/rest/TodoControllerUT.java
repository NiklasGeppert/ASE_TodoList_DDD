package de.dhbw.ase.plugins.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.ase.TodoService;
import de.dhbw.ase.Todo.TodoRepresentation;
import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.values.Status;
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

class TodoControllerUT {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoController todoController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
    }

    @Test
    void createTodo() throws Exception {
        TodoRepresentation todoRepresentation = new TodoRepresentation();
        when(todoService.createTodo(any(TodoRepresentation.class))).thenReturn(new TodoRepresentation());

        mockMvc.perform(post("/todo/createTodo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todoRepresentation)))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllPersonTodos() throws Exception {
        UUID personID = UUID.randomUUID();
        List<Todo> todos = Arrays.asList(new Todo(), new Todo());
        when(todoService.getAllPersonsTodos(personID)).thenReturn(todos);

        mockMvc.perform(get("/todo/allPersonTodos").param("personID", personID.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(todos.size()));
    }

    @Test
    void deleteTodo() throws Exception {
        UUID todoId = UUID.randomUUID();
        mockMvc.perform(delete("/todo/{todoId}", todoId))
                .andExpect(status().isAccepted());
    }

    @Test
    void changePerson() throws Exception {
        UUID todoId = UUID.randomUUID();
        UUID personId = UUID.randomUUID();
        mockMvc.perform(put("/todo/changeTodoPerson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("todoID", todoId.toString())
                        .param("personID", personId.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void getByStatus() throws Exception {
        List<Todo> todos = Arrays.asList(new Todo(), new Todo());
        when(todoService.getByStatus(any(Status.class))).thenReturn(todos);

        mockMvc.perform(get("/todo/todosByStatus/{status}", Status.OPEN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(todos.size()));
    }

    @Test
    void getByEnddate() throws Exception {
        String enddate = "2024-05-31"; // example enddate
        List<Todo> todos = Arrays.asList(new Todo(), new Todo());
        when(todoService.getByEnddate(enddate)).thenReturn(todos);

        mockMvc.perform(get("/todo/todosByEnddate").param("enddate", enddate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(todos.size()));
    }

    @Test
    void changeTodo() throws Exception {
        UUID todoId = UUID.randomUUID();
        TodoRepresentation todoRepresentation = new TodoRepresentation();
        when(todoService.updateTodo(todoId, todoRepresentation)).thenReturn(new TodoRepresentation());

        mockMvc.perform(put("/todo/changeTodo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", todoId.toString())
                        .content(asJsonString(todoRepresentation)))
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
