package br.com.pietro.controllers.v2;

import br.com.pietro.data.dto.v2.PersonDTOV2;
import br.com.pietro.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    ) public PersonDTOV2 findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTOV2> findAll(){
        return service.findAll();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(
            value = "/v2",
            produces= MediaType.APPLICATION_JSON_VALUE,
            consumes= MediaType.APPLICATION_JSON_VALUE
    ) public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return service.create(person);
    }

    @PutMapping(
            value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    ) public PersonDTOV2 update(@RequestBody PersonDTOV2 person){
        return service.update(person);
    }
}
