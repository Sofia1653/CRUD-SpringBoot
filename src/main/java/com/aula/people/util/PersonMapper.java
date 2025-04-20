package com.aula.people.util;

import com.aula.people.dto.request.PersonRequestDTO;
import com.aula.people.dto.response.PersonResponseDTO;
import com.aula.people.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {
    public Person toPerson(PersonRequestDTO personDTO){
        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .idade(personDTO.getIdade())
                .build();
    }

    public PersonResponseDTO toPersonDTO(Person person){
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPeolpleDTO(List<Person> peopleList){
        return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePersonData(Person person, PersonRequestDTO personDTO){
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setIdade(personDTO.getIdade());
    }
}
