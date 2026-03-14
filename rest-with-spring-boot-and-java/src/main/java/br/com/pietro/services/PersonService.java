package br.com.pietro.services;

import br.com.pietro.exception.handler.NotFoundRepositoryOperation;
import br.com.pietro.model.Person;
import br.com.pietro.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger= Logger.getLogger(PersonService.class.getName());
    private final PersonRepository repository;

    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Person findById(Long id){
        logger.info("Finding person");

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundRepositoryOperation("Not found"));
    }

    public List<Person> findAll(){
        logger.info("Returning all people");

        return repository.findAll();
    }

    public void delete(long id){
        logger.info("deleting person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundRepositoryOperation("Not found person for this ID"));

        repository.delete(entity);
    }

    public Person create(Person person){
        logger.info("Adicionando person");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating person");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new NotFoundRepositoryOperation("Not found"));

        entity.setFirstName(person.getFirstName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());

        return repository.save(entity);
    }
}
