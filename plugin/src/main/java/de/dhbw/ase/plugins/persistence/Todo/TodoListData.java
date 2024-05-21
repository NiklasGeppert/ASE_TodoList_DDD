package de.dhbw.ase.plugins.persistence.Todo;

import de.dhbw.ase.TodoList.TodoList;
import de.dhbw.ase.values.ListStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TodoListData extends JpaRepository<TodoList, UUID> {
    List<TodoList> findByListStatus(ListStatus status);
}
