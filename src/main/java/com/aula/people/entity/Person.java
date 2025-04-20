package com.aula.people.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_people")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Builder
    public Person(String name, String cpf, Integer idade) {
        this.name = name;
        this.cpf = cpf;
        this.idade = idade;
    }
}
