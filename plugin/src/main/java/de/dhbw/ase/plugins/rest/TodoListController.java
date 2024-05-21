package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.TodoListService;
import de.dhbw.ase.TodoService;
import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.TodoList.TodoList;
import de.dhbw.ase.TodoList.TodoListRepresentation;
import de.dhbw.ase.values.ListStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todoList")
public class TodoListController {

    private final TodoListService todoListService;
    private final TodoService todoService;

    @Autowired
    public TodoListController(final TodoListService todoListService, final TodoService todoService) {this.todoListService = todoListService;
    this.todoService = todoService;}

    @PostMapping(path = "/createTodoList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TodoListRepresentation createTodo(
            @RequestBody final TodoListRepresentation todoList)
    {
        return todoListService.createTodoList(todoList);
    }

    @GetMapping(value = "/getListByPersonId", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TodoList getTodoListbyPersonId(UUID personID) {
        return todoListService.getTodoListByPerson(personID);
    }

    @GetMapping(value = "/getListsByStatus", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoList> getTodoListsByStatus(ListStatus status){
        return todoListService.getTodoListByStatus(status);
    }

    @PutMapping(path = "/addTodoToList", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void addTodo(UUID personId,UUID todoID) {
        Todo newTodo = todoService.getTodo(todoID);
        todoListService.addTodo(personId,newTodo);
    }

    @DeleteMapping(path = "/{personId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTodo(@PathVariable UUID personId) {
        todoListService.deleteTodoListByPerson(personId);
    }

    @PutMapping(path = "/removeTodoToList", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void removeTodo(UUID personId,UUID todoID) {
        todoListService.removeTodo(personId, todoID);
    }
}
