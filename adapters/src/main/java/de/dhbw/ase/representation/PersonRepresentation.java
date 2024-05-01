package de.dhbw.ase.representation;

import de.dhbw.ase.values.EMail;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import lombok.Builder;

import java.util.UUID;

@Builder
public class PersonRepresentation {

    private UUID id;

    private PersonName name;
    private EMail eMail;
    private Gender gender;

    public PersonRepresentation(UUID id, PersonName name, EMail eMail, Gender gender) {
        this.id = id;
        this.name = name;
        this.eMail = eMail;
        this.gender = gender;
    }

    public PersonRepresentation(PersonName name, EMail eMail, Gender gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.eMail = eMail;
        this.gender = gender;
    }

    public PersonRepresentation() {}

    public UUID getId() {return id;}

    public PersonName getName() {return name;}

    public EMail geteMail() {return eMail;}

    public Gender getGender() {return gender;}
}
