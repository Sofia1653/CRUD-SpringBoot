package com.aula.people.dto.response;

import com.aula.people.entity.Person;
import lombok.Getter;

@Getter
public class PersonResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private Integer idade;

    public PersonResponseDTO(Person person) {
        this.id = (long) person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.idade = person.getIdade();
    }
}
