package de.dhbw.ase.TodoList;

import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.values.ListStatus;
import jakarta.persistence.*;


import java.util.List;
import java.util.UUID;

@Entity
public class TodoList {


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "todo_list_todos",
            joinColumns = @JoinColumn(name = "todo_list_id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id")
    )
    private List<Todo> todoList;
    private ListStatus listStatus;

    @Id
    private UUID personid;


    public TodoList(UUID personID, List<Todo> todoList, ListStatus listStatus) {
        this.personid = personID;
        this.todoList = todoList;
        this.listStatus = listStatus;
    }

    public TodoList(){}

    public UUID getPersonID() {return personid;}

    public void setPersonID(UUID personID) {this.personid = personID;}

    public List<Todo> getTodoList() {return todoList;}

    public void setTodoList(List<Todo> todoList) {this.todoList = todoList;}

    public ListStatus getListStatus() {return listStatus;}

    public void setListStatus(ListStatus listStatus) {this.listStatus = listStatus;}

}
