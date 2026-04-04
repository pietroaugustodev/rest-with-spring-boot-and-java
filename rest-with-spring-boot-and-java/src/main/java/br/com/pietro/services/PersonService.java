package br.com.pietro.services;

import br.com.pietro.data.dto.PersonDTO;
import br.com.pietro.exception.handler.NotFoundRepositoryOperation;
import br.com.pietro.model.Person;
import br.com.pietro.repository.PersonRepository;
import org.springframework.stereotype.Service;
import static br.com.pietro.mapper.ObjectMapper.parseObject;
import static br.com.pietro.mapper.ObjectMapper.parseListObject;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger= Logger.getLogger(PersonService.class.getName());
    private final PersonRepository repository;

    public PersonService(PersonRepository repository){
        this.repository = repository;
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

    public PersonDTO create(PersonDTO person){
        logger.info("Adicionando person");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
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
