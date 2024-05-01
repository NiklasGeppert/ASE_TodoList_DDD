package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.TodoList;
import de.dhbw.ase.representation.TodoListRepresentation;

public class TodoListMapper {
    public TodoListRepresentation toTodoListRepresentation(TodoList todoList) {
        return TodoListRepresentation.builder()
                .personID(todoList.getPersonID())
                .todoList(todoList.getTodoList())
                .listStatus(todoList.getListStatus())
                .build();
    }
}
