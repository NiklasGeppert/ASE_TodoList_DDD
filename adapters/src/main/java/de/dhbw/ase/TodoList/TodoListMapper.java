package de.dhbw.ase.TodoList;

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
