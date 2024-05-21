package de.dhbw.ase;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.exceptions.PersonNotFoundException;
import de.dhbw.ase.exceptions.TodoListNotFoundException;
import de.dhbw.ase.mappers.TodoListMapper;
import de.dhbw.ase.repositories.TodoListRepository;
import de.dhbw.ase.representation.TodoListRepresentation;
import de.dhbw.ase.values.ListStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;

    private final TodoListMapper todoListMapper;

    private static final String NotFoundMessage = "TodoList not found";

    @Autowired
    public TodoListService(TodoListRepository todoListRepository, TodoListMapper todoListMapper) {
        this.todoListRepository = todoListRepository;
        this.todoListMapper = todoListMapper;
    }

    public TodoListRepresentation createTodoList(TodoListRepresentation todoListrepresentation) {
        TodoList todoList = new TodoList(todoListrepresentation.getPersonID(),
                todoListrepresentation.getTodoList(),
                todoListrepresentation.getListStatus());

        return todoListMapper.toTodoListRepresentation(todoListRepository.save(todoList));
    }

    public TodoList getTodoListByPerson(UUID personID) {
        return todoListRepository.findById(personID)
                .orElse(null);
    }

    public List<TodoList> getTodoListByStatus(ListStatus status) {
        return todoListRepository.findbyStatus(status);
    }

    public void deleteTodoListByPerson(UUID personID) {
        Optional<TodoList> todoList = todoListRepository.findById(personID);
        if (todoList.isEmpty()){
            throw new TodoListNotFoundException(NotFoundMessage);
        }
        todoListRepository.delete(todoList.get());
    }

    public TodoList addTodo(UUID personID, Todo todo) {
        Optional<TodoList> todoList = todoListRepository.findById(personID);
        if (todoList.isEmpty()){
            throw new TodoListNotFoundException(NotFoundMessage);
        }
        return todoListRepository.insert(todoList.get(), todo);
    }

    public TodoList removeTodo(UUID personID, UUID todoID) {
        Optional<TodoList> todoList = todoListRepository.findById(personID);
        if (todoList.isEmpty()){
            throw new TodoListNotFoundException(NotFoundMessage);
        }
        return todoListRepository.remove(todoList.get(), todoID);
    }
}
