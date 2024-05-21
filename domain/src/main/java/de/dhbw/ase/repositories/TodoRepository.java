package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository{
    List<Todo> findByStatus(Status status);
    Optional<Todo> findById(UUID id);
    List<Todo> findByEnddate(EndDate enddate);
    List<Todo> findByPerson(UUID personId);
    void deleteById(UUID id);
    Todo save(Todo todo);
}
