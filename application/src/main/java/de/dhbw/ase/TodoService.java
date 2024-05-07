package de.dhbw.ase;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.exceptions.PersonNotFoundException;
import de.dhbw.ase.mappers.TodoMapper;
import de.dhbw.ase.repositories.TodoRepository;
import de.dhbw.ase.representation.TodoRepresentation;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    private final TodoMapper todoMapper;

    private static final String NotFoundMessage = "ToDo not found";

    @Autowired
    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper)
    {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    public TodoRepresentation createTodo(TodoRepresentation todoRepresentation){
        Todo todo = new Todo(todoRepresentation.getTitle(),
                todoRepresentation.getDescription(),
                todoRepresentation.getEnddate(),
                todoRepresentation.getPersonID(),
                todoRepresentation.getPlace()
        );

        return todoMapper.toTodoRepresentation(todo);
    }

    public Todo getTodo(UUID id){
        return todoRepository.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException(NotFoundMessage));
    }

    public void deleteTodo(UUID id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isEmpty()){
            throw new PersonNotFoundException(NotFoundMessage);
        }
        todoRepository.deleteById(id);
    }

    public TodoRepresentation updateTodo(UUID id, TodoRepresentation todoRepresentation){
        Todo todo = getTodo(id);
        todo.setTitle(todoRepresentation.getTitle());
        todo.setDescription(todoRepresentation.getDescription());
        todo.setEnddate(todoRepresentation.getEnddate());
        todo.setPersonID(todoRepresentation.getPersonID());
        todo.setPlace(todoRepresentation.getPlace());
        return todoMapper.toTodoRepresentation(todo);
    }

    public List<Todo> getAllPersonsTodos(UUID personId){
        return todoRepository.findByPerson(personId);
    }

    public List<Todo> getByEnddate(EndDate enddate){
        return todoRepository.findByEnddateBefore(enddate);
    }

    public List<Todo> getByStatus(Status status){
        return todoRepository.findByStatus(status);
    }
}
