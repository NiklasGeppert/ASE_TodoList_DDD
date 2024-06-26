package de.dhbw.ase.TodoList;

import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.values.ListStatus;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public class TodoListRepresentation {
    private UUID personID;
    private List<Todo> todoList;
    private ListStatus listStatus;

    public TodoListRepresentation(UUID personid, List<Todo> todoList, ListStatus listStatus) {
        this.personID = personid;
        this.todoList = todoList;
        this.listStatus = listStatus;
    }
    public TodoListRepresentation(){}

    public UUID getPersonID() {return personID;}

    public List<Todo> getTodoList() {return todoList;}

    public ListStatus getListStatus() {return listStatus;}
}
