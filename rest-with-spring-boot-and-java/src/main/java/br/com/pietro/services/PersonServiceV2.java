package br.com.pietro.services;

import br.com.pietro.data.dto.v1.PersonDTO;
import br.com.pietro.data.dto.v2.PersonDTOV2;
import br.com.pietro.exception.handler.NotFoundRepositoryOperation;
import br.com.pietro.mapper.custom.PersonV2Mapper;
import br.com.pietro.model.Person;
import br.com.pietro.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.pietro.mapper.ObjectMapper.parseListObject;
import static br.com.pietro.mapper.ObjectMapper.parseObject;

@Service
public class PersonServiceV2 {

    private final Logger logger= Logger.getLogger(PersonServiceV2.class.getName());
    private final PersonRepository repository;
    private final PersonV2Mapper mapperDTOV2;


    public PersonServiceV2(PersonRepository repository, PersonV2Mapper mapperDTOV2){
        this.repository = repository;
        this.mapperDTOV2 = mapperDTOV2;
    }

    public PersonDTO findById(Long id){
        logger.info("Finding person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundRepositoryOperation("Not found"));

        return parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findAll(){
        logger.info("Returning all people");

        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public void delete(long id){
        logger.info("deleting person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundRepositoryOperation("Not found person for this ID"));

        repository.delete(entity);
    }

    public PersonDTOV2 create(PersonDTOV2 person){
        logger.info("Adicionando person V2");

        var entity = mapperDTOV2.converterDTOV2toEntity(person);

        return mapperDTOV2.converterEntityToDTOV2(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating person");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new NotFoundRepositoryOperation("Not found"));

        entity.setFirstName(person.getFirstName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());

        return parseObject(repository.save(entity), PersonDTO.class);
    }
}
