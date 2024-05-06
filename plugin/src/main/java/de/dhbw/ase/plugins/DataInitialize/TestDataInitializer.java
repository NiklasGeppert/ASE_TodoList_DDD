package de.dhbw.ase.plugins.DataInitialize;

import de.dhbw.ase.entities.Person;
import de.dhbw.ase.repositories.PersonRepository;
import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TestDataInitializer implements ApplicationRunner {
    private final PersonRepository personRepository;

    public TestDataInitializer(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        PersonName personName = new PersonName("Geppert", "Niklas");
        Email email = new Email("testNiklas@example.com");
        Gender gender = Gender.MALE;

        Person person = new Person(UUID.randomUUID(), personName, email, gender);
        personRepository.save(person);

        PersonName personName2 = new PersonName("Walter", "Chiara");
        Email email2 = new Email("walterChiara@example.com");
        Gender gender2 = Gender.FEMALE;

        Person person2 = new Person(UUID.randomUUID(), personName2, email2, gender2);
        personRepository.save(person2);

        PersonName personName3 = new PersonName("Hemmerich", "Alexander");
        Email email3 = new Email("EricHem@example.com");
        Gender gender3 = Gender.MALE;

        Person person3 = new Person(UUID.randomUUID(), personName3, email3, gender3);
        personRepository.save(person3);

        PersonName personName4 = new PersonName("Wiemann", "Anna");
        Email email4 = new Email("WieAnna@example.com");
        Gender gender4 = Gender.FEMALE;

        Person person4 = new Person(UUID.randomUUID(), personName4, email4, gender4);
        personRepository.save(person4);
    }
}
