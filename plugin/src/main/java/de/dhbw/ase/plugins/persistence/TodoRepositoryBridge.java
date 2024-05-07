package de.dhbw.ase.plugins.persistence;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.repositories.TodoRepository;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoRepositoryBridge implements TodoRepository {

    private final TodoData todoData;

    @Autowired
    public TodoRepositoryBridge(TodoData todoData){this.todoData = todoData;}


    @Override
    public List<Todo> findByStatus(Status status) {
        return todoData.findByStatus(status);
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        return todoData.findByTodoId(id);
    }

    @Override
    public List<Todo> findByEnddateBefore(EndDate endDate) {
        return todoData.findByEndDate(endDate);
    }

    @Override
    public List<Todo> findByPerson(UUID personId) {
        return todoData.findByPerson(personId);
    }

    @Override
    public void deleteById(UUID id) {
        todoData.deleteById(id);
    }
}
