package de.dhbw.ase.mappers;

import de.dhbw.ase.entities.Person;
import de.dhbw.ase.representation.PersonRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonMapper {

    public List<PersonRepresentation> toPersonRepresentationList(List<Person> personList) {
        return personList.stream()
                .map(this:: toPersonRepresentation)
                .toList();
    }

    public PersonRepresentation toPersonRepresentation(Person person) {
        return PersonRepresentation.builder()
                .id(person.getId())
                .name(person.getName())
                .eMail(person.geteMail())
                .gender(person.getGender())
                .build();
    }
}
