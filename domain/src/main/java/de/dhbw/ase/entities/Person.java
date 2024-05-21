package de.dhbw.ase.entities;

import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.ListStatus;
import de.dhbw.ase.values.PersonName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Person {
    @Id
    private UUID id;
    @Embedded
    private PersonName name;
    @Embedded
    private Email email;
    private Gender gender;;

    public Person(UUID id, PersonName name, Email email, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;

    }

    public Person() {
    }

    public UUID getId() {  return id;}

    public void setId(UUID id) { this.id = id; }

    public PersonName getName() { return name; }

    public void setName(PersonName name) { this.name = name; }

    public Email geteMail() { return email; }

    public void setEmail(Email email) { this.email = email; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }


}
