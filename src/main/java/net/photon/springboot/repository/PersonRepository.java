package net.photon.springboot.repository;

import net.photon.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstName(final String firstName);

    List<Person> findByLastNameIgnoreCaseOrderByFirstNameAsc(final String lastName);

}
