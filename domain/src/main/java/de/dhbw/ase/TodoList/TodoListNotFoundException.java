package de.dhbw.ase.TodoList;

import de.dhbw.ase.exceptions.NotFoundException;

public class TodoListNotFoundException extends NotFoundException {
    public TodoListNotFoundException(String message){super(message);}
}
