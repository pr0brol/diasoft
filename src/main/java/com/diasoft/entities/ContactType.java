package com.diasoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "contact_type")
@XmlRootElement(name = "contactType")
public class ContactType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String type;

    @OneToMany(mappedBy = "contactType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contacts;

    @Override
    public String toString() {
        return "ContactType{" +
                "type='" + type + '\'' +
                '}';
    }
}
