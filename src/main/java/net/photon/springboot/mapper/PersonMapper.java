package net.photon.springboot.mapper;

import net.photon.springboot.beans.PersonBean;
import net.photon.springboot.model.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonBean toPersonBean(Person person);

    List<PersonBean> toPersonBeanList(List<Person> personList);

    @InheritInverseConfiguration
    Person toPerson(PersonBean personBean);

}
