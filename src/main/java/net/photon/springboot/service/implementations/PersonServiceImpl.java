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

    @Override
    public Person getPersonById(long id) {
        return personRepository.getOne(id);
    }

    @Override
    public boolean save(Person person) {
        Person p = personRepository.save(person);
        if (p != null && p.getPersonId() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
