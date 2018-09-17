package net.photon.springboot.service;

import net.photon.springboot.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person getPersonById(long id);

    boolean save(Person person);
}
