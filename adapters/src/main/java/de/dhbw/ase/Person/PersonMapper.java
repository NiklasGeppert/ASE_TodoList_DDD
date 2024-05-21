package de.dhbw.ase.Person;

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
                .getemail(person.geteMail())
                .gender(person.getGender())
                .build();
    }
}
