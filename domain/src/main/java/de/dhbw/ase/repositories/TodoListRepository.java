package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.ToDoList;
import de.dhbw.ase.values.ListStatus;

import java.util.List;
import java.util.Optional;

public interface TodoListRepository {
    ToDoList insert(ToDoList toDoList);
    ToDoList save(ToDoList toDoList);
    void delete(ToDoList toDoList);
    Optional<ToDoList> findById(String id);
    List<ToDoList> findbyStatus(ListStatus status);
}
