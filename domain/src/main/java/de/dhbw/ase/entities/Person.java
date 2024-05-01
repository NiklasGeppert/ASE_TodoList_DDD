package de.dhbw.ase.entities;

import de.dhbw.ase.values.EMail;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;

import java.util.UUID;

public class Person {
    private UUID id;
    private PersonName name;
    private EMail email;
    private Gender gender;

    public Person(UUID id, PersonName name, EMail email, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public UUID getId() {  return id;}

    public void setId(UUID id) { this.id = id; }

    public PersonName getName() { return name; }

    public void setName(PersonName name) { this.name = name; }

    public EMail getEmail() { return email; }

    public void setEmail(EMail email) { this.email = email; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

}
