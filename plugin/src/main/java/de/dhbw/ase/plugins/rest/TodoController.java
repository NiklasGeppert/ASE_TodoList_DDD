package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.TodoService;
import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.representation.PersonRepresentation;
import de.dhbw.ase.representation.TodoRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(final TodoService todoService) { this.todoService = todoService;}

    @PostMapping(path = "/createTodo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TodoRepresentation createTodo(
            @RequestBody final TodoRepresentation todo)
    {
        return todoService.createTodo(todo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllPersonTodos(UUID personID) {
        return todoService.getAllPersonsTodos(personID);
    }


}
