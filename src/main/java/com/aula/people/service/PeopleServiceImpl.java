package com.aula.people.service;

import com.aula.people.dto.request.PersonRequestDTO;
import com.aula.people.dto.response.PersonResponseDTO;
import com.aula.people.util.PersonMapper;
import com.aula.people.entity.Person;
import com.aula.people.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PeopleServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {
        return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return personMapper.toPeolpleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(Long id, PersonRequestDTO personDTO) {
        Person person = returnPerson(id);
        personMapper.updatePersonData(person, personDTO);
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person with id " + id + " was deleted";
    }

    private Person returnPerson(Long id){
        return personRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Person Not Found"));
    }
}
