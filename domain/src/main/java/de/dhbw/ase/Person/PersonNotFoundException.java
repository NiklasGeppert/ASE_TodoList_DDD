package de.dhbw.ase.Person;

import de.dhbw.ase.exceptions.NotFoundException;

public class PersonNotFoundException extends NotFoundException {
    public PersonNotFoundException(String message){super(message);}
}
