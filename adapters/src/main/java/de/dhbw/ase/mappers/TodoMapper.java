package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.representation.TodoRepresentation;

public class TodoMapper {
    public TodoRepresentation toTodoRepresentation(Todo todo) {
        return TodoRepresentation.builder()
                .id(todo.getTodoID())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .status(todo.getStatus())
                .enddate(todo.getEnddate())
                .personID(todo.getPersonID())
                .place(todo.getPlace())
                .build();
    }
}
