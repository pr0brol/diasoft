package com.diasoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "persons")
@XmlRootElement(name = "person")
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

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", position='" + position + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
