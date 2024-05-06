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
    private Email getemail;
    private Gender gender;

    public PersonRepresentation(UUID id, PersonName name, Email getemail, Gender gender) {
        this.id = id;
        this.name = name;
        this.getemail = getemail;
        this.gender = gender;
    }

    public PersonRepresentation(PersonName name, Email getemail, Gender gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.getemail = getemail;
        this.gender = gender;
    }

    public PersonRepresentation() {}

    public UUID getId() {return id;}

    public PersonName getName() {return name;}

    public Email getemail() {return getemail;}

    public Gender getGender() {return gender;}


}
