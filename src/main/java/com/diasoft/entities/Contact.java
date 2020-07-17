package com.diasoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String number;

    @Column(name = "person_id", insertable = false, updatable = false)
    private Long person_id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "contact_type_id", insertable = false, updatable = false)
    private Long contact_type_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_type_id")
    private ContactType contactType;

}
