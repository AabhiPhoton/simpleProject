package net.photon.springboot.mapper;

import net.photon.springboot.beans.PersonBean;
import net.photon.springboot.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonBean toPersonBean(Person person);

}
