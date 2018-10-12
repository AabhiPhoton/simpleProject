package net.photon.springboot.service.implementations;

import net.photon.springboot.beans.PersonBean;
import net.photon.springboot.mapper.PersonMapper;
import net.photon.springboot.model.Person;
import net.photon.springboot.repository.PersonRepository;
import net.photon.springboot.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Deprecated
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    @Deprecated
    public Person getPersonById(long id) {
        return personRepository.getOne(id);
    }

    @Override
    public boolean save(Person person) {
        Person p = personRepository.save(person);
        return p != null && p.getPersonId() > 0L;
    }

    @Override
    public PersonBean getPersonBean(long id) {
        return PersonMapper.INSTANCE.toPersonBean(personRepository.getOne(id));
    }

    @Override
    public List<PersonBean> getAllPersonBeans() {
        return PersonMapper.INSTANCE.toPersonBeanList(personRepository.findAll());
    }

    @Override
    public List<PersonBean> getPersonBeansByName(String firstName) {
        List<Person> persons = personRepository.findByFirstName(firstName);
        return PersonMapper.INSTANCE.toPersonBeanList(persons);
    }

    @Override
    public List<PersonBean> getPersonsByLastName(String lastName) {
        LOGGER.info("Inside getPersonsByLastName");
        List<Person> personList = personRepository.findByLastNameIgnoreCaseOrderByFirstNameAsc(lastName);
        return PersonMapper.INSTANCE.toPersonBeanList(personList);
    }


    @SuppressWarnings("unused")
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
