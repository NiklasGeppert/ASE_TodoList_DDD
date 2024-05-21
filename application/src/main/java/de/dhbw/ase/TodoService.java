package de.dhbw.ase;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.exceptions.PersonNotFoundException;
import de.dhbw.ase.exceptions.TodoNotFoundException;
import de.dhbw.ase.mappers.TodoMapper;
import de.dhbw.ase.repositories.TodoRepository;
import de.dhbw.ase.representation.TodoRepresentation;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        System.out.println("Creating todo with representation: " + todoRepresentation);
        Todo todo = new Todo(
                todoRepresentation.getTitle(),
                todoRepresentation.getDescription(),
                todoRepresentation.getEnddate(),
                todoRepresentation.getPersonID()
        );
        Todo savedTodo = todoRepository.save(todo);
        System.out.println("Saved todo: " + savedTodo);

        return todoMapper.toTodoRepresentation(savedTodo);
    }

    public Todo getTodo(UUID id){
        return todoRepository.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException(NotFoundMessage));
    }

    public void deleteTodo(UUID id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isEmpty()){
            throw new TodoNotFoundException(NotFoundMessage);
        }
        todoRepository.deleteById(id);
    }

    public TodoRepresentation updateTodo(UUID id, TodoRepresentation todoRepresentation){
        Todo todo = getTodo(id);
        todo.setTitle(todoRepresentation.getTitle());
        todo.setDescription(todoRepresentation.getDescription());
        todo.setendDate(todoRepresentation.getEnddate());
        todo.setPersonID(todoRepresentation.getPersonID());
        return todoMapper.toTodoRepresentation(todo);
    }

    public List<Todo> getAllPersonsTodos(UUID personId){
        return todoRepository.findByPerson(personId);
    }

    public List<Todo> getByEnddate(String enddateString){
        EndDate enddate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(enddateString, formatter);
            enddate = new EndDate(localDate);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format, please use yyyy-MM-dd", e);
        }
        return todoRepository.findByEnddate(enddate);
    }

    public List<Todo> getByStatus(Status status){
        return todoRepository.findByStatus(status);
    }

    public void changePerson(UUID id, UUID personId){
        Todo todo = getTodo(id);
        todo.setPersonID(personId);
    }
}
