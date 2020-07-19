package com.diasoft.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NoArgsConstructor
@Data
@Table(name = "contacts")
@XmlRootElement(name = "contact")
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

    @ManyToOne
    @JoinColumn(name="contact_type_id", referencedColumnName = "id")
    private ContactType contactType;


    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", contactType=" + contactType +
                '}';
    }
}
