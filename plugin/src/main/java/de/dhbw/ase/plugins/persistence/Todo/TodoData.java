package de.dhbw.ase.plugins.persistence.Todo;

import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoData extends JpaRepository<Todo, UUID> {

    List<Todo> findByStatus(Status status);

    List<Todo> findByPersonID(UUID personID);

    List<Todo>  findByEndDate(EndDate endDate);

    Optional<Todo> findByTodoId(UUID id);
}
