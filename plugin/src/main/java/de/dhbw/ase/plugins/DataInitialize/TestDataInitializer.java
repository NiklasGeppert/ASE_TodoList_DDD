package de.dhbw.ase.plugins.DataInitialize;

import de.dhbw.ase.entities.Person;
import de.dhbw.ase.entities.Todo;
import de.dhbw.ase.repositories.PersonRepository;
import de.dhbw.ase.repositories.TodoListRepository;
import de.dhbw.ase.repositories.TodoRepository;
import de.dhbw.ase.values.Email;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Gender;
import de.dhbw.ase.values.PersonName;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Component
public class TestDataInitializer implements ApplicationRunner {
    private final PersonRepository personRepository;
    private final TodoListRepository todoListRepository;
    private final TodoRepository todoRepository;

    public TestDataInitializer(PersonRepository personRepository, TodoListRepository todoListRepository, TodoRepository todoRepository) {
        this.personRepository = personRepository;
        this.todoListRepository = todoListRepository;
        this.todoRepository = todoRepository;
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

        String[] titles = {"Todo1", "Todo2", "Todo3", "Todo4"};
        String[] descriptions = {"Description1", "Description2", "Description3", "Description4"};
        LocalDate endDate = LocalDate.now().plusDays(new Random().nextInt(30));
        UUID personID = person.getId();

        String randomTitle = titles[new Random().nextInt(titles.length)];
        String randomDescription = descriptions[new Random().nextInt(descriptions.length)];

        String randomTitle2 = titles[new Random().nextInt(titles.length)];
        String randomDescription2 = descriptions[new Random().nextInt(descriptions.length)];
        LocalDate endDate2 = LocalDate.now().plusDays(new Random().nextInt(30));

        String randomTitle3 = titles[new Random().nextInt(titles.length)];
        String randomDescription3 = descriptions[new Random().nextInt(descriptions.length)];
        LocalDate endDate3 = LocalDate.now().plusDays(new Random().nextInt(30));

        String randomTitle4 = titles[new Random().nextInt(titles.length)];
        String randomDescription4 = descriptions[new Random().nextInt(descriptions.length)];
        LocalDate endDate4 = LocalDate.now().plusDays(new Random().nextInt(30));


        Todo todo = new Todo(randomTitle, randomDescription, new EndDate(endDate), personID);
        Todo todo2 = new Todo(randomTitle2, randomDescription2, new EndDate(endDate2), personID);
        Todo todo3 = new Todo(randomTitle3, randomDescription3, new EndDate(endDate3), personID);
        Todo todo4 = new Todo(randomTitle4, randomDescription4, new EndDate(endDate4), personID);

        todoRepository.save(todo);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        todoRepository.save(todo4);

    }
}
