package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.TodoService;
import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.Todo.TodoRepresentation;
import de.dhbw.ase.values.Status;
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

    @GetMapping(value = "/allPersonTodos", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllPersonTodos(UUID personID) {
        return todoService.getAllPersonsTodos(personID);
    }

    @DeleteMapping(path = "/{todoId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTodo(UUID todoId) {
        todoService.deleteTodo(todoId);
    }

    @PutMapping(path = "/changeTodoPerson", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void changePerson(UUID todoID,UUID personID) {
        todoService.changePerson(todoID, personID);
    }

    @GetMapping(value = "/todosByStatus/{status}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getByStatus(@PathVariable Status status) {
        return todoService.getByStatus(status);
    }

    @GetMapping(value = "/todosByEnddate", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getByStatus(String enddate) {
        return todoService.getByEnddate(enddate);
    }

    @PutMapping(path = "/changeTodo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TodoRepresentation changeTodo(UUID id, @RequestBody TodoRepresentation todo){
        return todoService.updateTodo(id, todo);
    }
}
