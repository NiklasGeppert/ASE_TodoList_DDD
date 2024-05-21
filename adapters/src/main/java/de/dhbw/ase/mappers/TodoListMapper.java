package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.representation.TodoListRepresentation;
import org.springframework.stereotype.Component;

@Component
public class TodoListMapper {
    public TodoListRepresentation toTodoListRepresentation(TodoList todoList) {
        return TodoListRepresentation.builder()
                .personID(todoList.getPersonID())
                .todoList(todoList.getTodoList())
                .listStatus(todoList.getListStatus())
                .build();
    }
}
