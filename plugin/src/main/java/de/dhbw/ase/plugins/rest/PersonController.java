package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.Person.PersonRepresentation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import de.dhbw.ase.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {this.personService = personService;}

    @PostMapping(path = "/createPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonRepresentation createPerson(
            @RequestBody final PersonRepresentation person)
    {
        return personService.createPerson(person);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<PersonRepresentation> getAllPersons()
    {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PersonRepresentation getPersonById(
            @PathVariable UUID personId)
    {
        return personService.getById(personId);
    }

    @PutMapping(path="/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonRepresentation updatePerson(@PathVariable UUID personId,
                                             @Parameter(description = "Updated the Information of the Person selected.")
                                             @RequestBody final PersonRepresentation person)
    {
        return personService.updatePerson(personId, person);
    }

    @DeleteMapping(path = "/{personId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePerson(@PathVariable UUID personId)
    {
        personService.deletePerson(personId);
    }

}
