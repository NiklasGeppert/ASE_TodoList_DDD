package de.dhbw.ase.representation;

import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class PersonRepresentation {

    private UUID id;

    private PersonName name;
    private Email eMail;
    private Gender gender;

    public PersonRepresentation(UUID id, PersonName name, Email eMail, Gender gender) {
        this.id = id;
        this.name = name;
        this.eMail = eMail;
        this.gender = gender;
    }

    public PersonRepresentation(PersonName name, Email eMail, Gender gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.eMail = eMail;
        this.gender = gender;
    }

    public PersonRepresentation() {}

}
