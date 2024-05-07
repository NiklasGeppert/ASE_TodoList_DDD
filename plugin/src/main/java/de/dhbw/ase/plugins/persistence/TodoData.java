package de.dhbw.ase.plugins.persistence;

import de.dhbw.ase.entities.Person;
import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoData extends JpaRepository<TodoData, UUID> {

    List<Todo> findByStatus(Status status);

    List<Todo> findByPerson(UUID personId);

    List<Todo>  findByEndDate(EndDate endDate);

    Optional<Todo> findByTodoId(UUID id);
}
