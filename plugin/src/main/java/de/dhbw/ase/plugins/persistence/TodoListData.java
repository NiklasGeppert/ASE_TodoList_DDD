package de.dhbw.ase.plugins.persistence;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.values.ListStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoListData extends JpaRepository<TodoList, UUID> {
    List<TodoList> findByListStatus(ListStatus status);
}
