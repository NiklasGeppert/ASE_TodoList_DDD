package de.dhbw.ase.Todo;

import de.dhbw.ase.exceptions.NotFoundException;

public class TodoNotFoundException extends NotFoundException {
    public TodoNotFoundException(String message){super(message);}
}
