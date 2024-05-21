package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.representation.TodoRepresentation;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoRepresentation toTodoRepresentation(Todo todo) {
        if (todo == null) {
            System.out.println("Todo is null!");
            return null;
        }

        System.out.println("Mapping Todo: " + todo);

        return TodoRepresentation.builder()
                .todoid(todo.getTodoID())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .status(todo.getStatus())
                .enddate(todo.getendDate())
                .personID(todo.getPersonID())
                .build();
    }
}
