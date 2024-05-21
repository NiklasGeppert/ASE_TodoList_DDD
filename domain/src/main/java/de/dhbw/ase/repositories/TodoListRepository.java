package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.values.ListStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoListRepository {
    TodoList insert(TodoList todoList, Todo todo);
    TodoList save(TodoList toDoList);
    void delete(TodoList toDoList);
    Optional<TodoList> findById(UUID id);
    List<TodoList> findbyStatus(ListStatus status);
    TodoList remove(TodoList todoList, UUID todoId);
}
