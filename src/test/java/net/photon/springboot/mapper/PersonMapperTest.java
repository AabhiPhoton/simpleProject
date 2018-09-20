package net.photon.springboot.mapper;

import net.photon.springboot.beans.PersonBean;
import net.photon.springboot.model.Person;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PersonMapperTest {

    @Test
    public void toPerson() {
        Person person = new Person("Jack", "Jones");

        PersonBean bean = PersonMapper.INSTANCE.toPersonBean(person);

        assertThat(bean, is(not(nullValue())));

    }
}