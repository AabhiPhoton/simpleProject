package net.photon.springboot.service.implementations;

import net.photon.springboot.Repository.PersonRepository;
import net.photon.springboot.model.Person;
import net.photon.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
