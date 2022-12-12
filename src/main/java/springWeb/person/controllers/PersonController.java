package springWeb.person.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springWeb.person.models.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private List<Person> persons = new ArrayList<>();

    @PostMapping
    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) { //extract the value
        return persons.stream()
                .filter(element ->element.getId() == id)
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"person not found"));
    }

    @GetMapping
    public List<Person> getAll () {
        return persons;
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        Person personFromSystem = getPerson(person.getId());
        personFromSystem.setName(person.getName());
        personFromSystem.setAge(person.getAge());
        return personFromSystem;
    }


    @DeleteMapping
    public void deletePerson(@RequestParam int id) {
        if (!persons.remove(new Person(id, null, 0))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found");
        }
    }

    @PostConstruct
    public void init() {
        persons.add(new Person(1,"adam",10));
        persons.add(new Person(2,"bdam",20));
        persons.add(new Person(3,"cdam",30));
    }

}
