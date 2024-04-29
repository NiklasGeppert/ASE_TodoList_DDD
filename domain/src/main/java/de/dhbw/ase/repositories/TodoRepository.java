package de.dhbw.ase.repositories;

import de.dhbw.ase.entities.Person;
import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.values.EndDatum;
import de.dhbw.ase.values.Status;

import java.util.List;
import java.util.UUID;


public interface TodoRepository{
    List<Todo> findByStatus(Status status);
    Todo findById(UUID id);
    List<Todo> findByEnddateBefore(EndDatum endDate);
    List<Todo> findbyPerson(Person person);
}
