package net.photon.springboot.Repository;

import net.photon.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

}
