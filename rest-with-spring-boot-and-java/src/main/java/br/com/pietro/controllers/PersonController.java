package br.com.pietro.controllers;

import br.com.pietro.model.Person;
import br.com.pietro.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(
            produces= MediaType.APPLICATION_JSON_VALUE,
            consumes= MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }
}
