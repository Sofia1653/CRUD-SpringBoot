package com.aula.people.controller;

import com.aula.people.dto.request.PersonRequestDTO;
import com.aula.people.dto.response.PersonResponseDTO;
import com.aula.people.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    private ResponseEntity<List<PersonResponseDTO>> findAll(){
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    private ResponseEntity<PersonResponseDTO> register(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder){
        PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);
        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.ge

                tId()).toUri();
        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.update(id,personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(personService.delete(id));
    }
}
