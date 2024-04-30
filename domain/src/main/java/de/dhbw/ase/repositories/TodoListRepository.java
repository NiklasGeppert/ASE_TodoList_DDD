package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.values.ListStatus;

import java.util.List;
import java.util.Optional;

public interface TodoListRepository {
    TodoList insert(TodoList toDoList);
    TodoList save(TodoList toDoList);
    void delete(TodoList toDoList);
    Optional<TodoList> findById(String id);
    List<TodoList> findbyStatus(ListStatus status);
}
