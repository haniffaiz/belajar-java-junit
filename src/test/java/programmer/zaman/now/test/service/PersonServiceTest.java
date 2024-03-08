package programmer.zaman.now.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);

    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> {
            personService.get("not found");
        });
    }

    @Test
    void testPersonSuccess() {
        //menambah behavior ke mock object
        Mockito.when(personRepository.selectById("hanif"))
                .thenReturn(new Person("hanif", "Hanif"));

        var person = personService.get("hanif");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("hanif", person.getId());
        Assertions.assertEquals("Hanif", person.getName());
    }
}
