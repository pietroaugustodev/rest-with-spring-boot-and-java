package br.com.pietro.mapper.custom;

import br.com.pietro.data.dto.v2.PersonDTOV2;
import br.com.pietro.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonV2Mapper {

    public PersonDTOV2 converterEntityToDTOV2(Person person) {
        var dtoV2 = new PersonDTOV2();

        dtoV2.setFirstName(person.getFirstName());
        dtoV2.setAdress(person.getAdress());
        dtoV2.setGender(person.getGender());
        dtoV2.setBirthDay(new Date());
        dtoV2.setLastName(person.getLastName());

        return dtoV2;
    }

    public Person converterDTOV2toEntity(PersonDTOV2 dtoV2) {
        var entity = new Person();

        entity.setFirstName(dtoV2.getFirstName());
        entity.setAdress(dtoV2.getAdress());
        entity.setGender(dtoV2.getGender());
        entity.setLastName(dtoV2.getLastName());

        // Esperando atualização da entity para V2
        // entity.setBirthDay(new Date());

        return entity;
    }
}
