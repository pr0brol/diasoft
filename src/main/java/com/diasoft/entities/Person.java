package com.diasoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotNull
    private String first_name;

    @Column
    @NotNull
    private String last_name;

    @Column
    private String middle_name;

    @Column
    private String position;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Contact> contacts;

}
