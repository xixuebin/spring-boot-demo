package com.yeahmobi.controller;

import com.google.common.collect.Lists;
import com.yeahmobi.rest.Person;
import com.yeahmobi.security.repository.PersonRepository;
import com.yeahmobi.service.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {
    private static final List<Person> persons;

    private final PersonRepository personRepository;


    static {
        persons = new ArrayList<>();
        persons.add(new Person("Hello", "World"));
        persons.add(new Person("Foo", "Bar"));
    }

    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService,
        PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }


    @RequestMapping(path = "/personspage", method = RequestMethod.GET)
    public Page<Person> getPersonsPage(Pageable pageable) {

        if (personRepository.count() < 40){
            List<Person> persons = Lists.newArrayList();
            for (int i=0; i< 50; i++){
                Person p = new Person("hello" + i, "world" + i);
                persons.add(p);
            }
            personRepository.saveAll(persons);
        }

        return personService.listAllByPage(pageable);
    }


    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public static List<Person> getPersons() {
        return persons;
    }

    @RequestMapping(path = "/persons/{name}", method = RequestMethod.GET)
    public static Person getPerson(@PathVariable("name") String name) {
        return persons.stream()
                .filter(person -> name.equalsIgnoreCase(person.getName()))
                .findAny().orElse(null);
    }
}
