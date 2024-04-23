package de.dhbw.ase.entities;

import de.dhbw.ase.values.ListStatus;

import java.util.List;
import java.util.UUID;

public class ToDoList {
    private UUID personID;
    private List<Todo> todoList;
    private ListStatus listStatus;

    public ToDoList(UUID personID, List<Todo> todoList, ListStatus listStatus) {
        this.personID = personID;
        this.todoList = todoList;
        this.listStatus = listStatus;
    }

    public UUID getPersonID() {return personID;}

    public void setPersonID(UUID personID) {this.personID = personID;}

    public List<Todo> getTodoList() {return todoList;}

    public void setTodoList(List<Todo> todoList) {this.todoList = todoList;}

    public ListStatus getListStatus() {return listStatus;}

    public void setListStatus(ListStatus listStatus) {this.listStatus = listStatus;}

}
