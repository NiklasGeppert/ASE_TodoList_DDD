package de.dhbw.ase.plugins.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.ase.PersonService;
import de.dhbw.ase.Person.PersonRepresentation;
import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PersonControllerUT {

    private MockMvc mockMvc;

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    void createPerson() throws Exception {
        PersonName personName = new PersonName("Doe", "John");
        Email email = new Email("john.doe@example.com");
        Gender gender = Gender.MALE; // Set the gender according to your implementation
        PersonRepresentation personRepresentation = new PersonRepresentation(UUID.randomUUID(), personName, email, gender);
        when(personService.createPerson(any())).thenReturn(personRepresentation);

        mockMvc.perform(post("/person/createPerson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(personRepresentation)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name.Nachname").value("Doe"))
                .andExpect(jsonPath("$.name.Vorname").value("John"))
                .andExpect(jsonPath("$.getemail.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("MALE")); // Adjust the value as per your implementation
    }

    @Test
    void getAllPersons() throws Exception {
        PersonName personName = new PersonName("Doe", "John");
        Email email = new Email("john.doe@example.com");
        Gender gender = Gender.MALE; // Set the gender according to your implementation
        PersonRepresentation personRepresentation = new PersonRepresentation(UUID.randomUUID(), personName, email, gender);
        when(personService.getAllPersons()).thenReturn(Collections.singletonList(personRepresentation));

        mockMvc.perform(get("/person")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name.Nachname").value("Doe"))
                .andExpect(jsonPath("$[0].name.Vorname").value("John"))
                .andExpect(jsonPath("$[0].getemail.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[0].gender").value("MALE")); // Adjust the value as per your implementation
    }

    @Test
    void getPersonById() throws Exception {
        UUID personId = UUID.randomUUID();
        PersonName personName = new PersonName("Doe", "John");
        Email email = new Email("john.doe@example.com");
        Gender gender = Gender.MALE; // Set the gender according to your implementation
        PersonRepresentation personRepresentation = new PersonRepresentation(personId, personName, email, gender);
        when(personService.getById(personId)).thenReturn(personRepresentation);

        mockMvc.perform(get("/person/{personId}", personId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name.Nachname").value("Doe"))
                .andExpect(jsonPath("$.name.Vorname").value("John"))
                .andExpect(jsonPath("$.getemail.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("MALE")); // Adjust the value as per your implementation
    }

    @Test
    void updatePerson() throws Exception {
        UUID personId = UUID.randomUUID();
        PersonName personName = new PersonName("Doe", "John");
        Email email = new Email("john.doe@example.com");
        Gender gender = Gender.MALE; // Set the gender according to your implementation
        PersonRepresentation personRepresentation = new PersonRepresentation(personId, personName, email, gender);
        when(personService.updatePerson(any(UUID.class), any(PersonRepresentation.class))).thenReturn(personRepresentation);

        mockMvc.perform(put("/person/{personId}", personId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(personRepresentation)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.name.Nachname").value("Doe"))
                .andExpect(jsonPath("$.name.Vorname").value("John"))
                .andExpect(jsonPath("$.getemail.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("MALE")); // Adjust the value as per your implementation
    }

    @Test
    void deletePerson() throws Exception {
        UUID personId = UUID.randomUUID();

        mockMvc.perform(delete("/person/{personId}", personId))
                .andExpect(status().isAccepted());
    }



    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
