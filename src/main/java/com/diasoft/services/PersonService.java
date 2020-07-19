package com.diasoft.services;


import com.diasoft.DAO.PersonDao;
import com.diasoft.entities.Contact;
import com.diasoft.entities.ContactType;
import com.diasoft.entities.Person;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class PersonService {

    private PersonDao personDao = new PersonDao();
    private ContactTypeService contactTypeService = new ContactTypeService();
    private ContactService contactService = new ContactService();

    public void saveOrUpdate(HttpServletRequest req) {
        String fname = req.getParameter("firstName");
        String lname = req.getParameter("lastName");
        String mname = req.getParameter("middleName");
        String position = req.getParameter("position");

        String number = req.getParameter("number");
        String type = req.getParameter("type");

        Person person = new Person();
        Contact contact = new Contact();


        ContactType contactType = contactTypeService.findTypeByName(type);
        if (contactType == null) {
            contactType = new ContactType();
            contactType.setType(type);
            contactTypeService.save(contactType);
            contactType = contactTypeService.findTypeByName(type);
        }

        if (personDao.find(fname, lname) == null) {
            person.setFirst_name(fname);
            person.setLast_name(lname);
            person.setMiddle_name(mname);
            person.setPosition(position);

            personDao.save(person);
            person = personDao.find(fname, lname);

            contact.setNumber(number);
            contact.setPerson(person);
            contact.setContactType(contactType);

            contactService.save(contact);

            person.getContacts().add(contact);

            personDao.update(person);

        } else {
            person = personDao.find(fname, lname);
            person.setFirst_name(fname);
            person.setLast_name(lname);
            person.setMiddle_name(mname);
            person.setPosition(position);

            contact = contactService.findContactByNumber(number);
            if (contact == null) {
                contact = new Contact();
                contact.setNumber(number);
                contact.setContactType(contactType);
                contact.setPerson(person);

                if (person.getContacts() == null) {
                    person.setContacts(new ArrayList<>());
                }

                person.getContacts().add(contact);

                personDao.update(person);
            }
        }
    }

    public void update(HttpServletRequest req){
        String fname = req.getParameter("firstName");
        String lname = req.getParameter("lastName");
        String mname = req.getParameter("middleName");
        String position = req.getParameter("position");

        String number = req.getParameter("number");
        String type = req.getParameter("type");

        Person person = personDao.find(fname, lname);
        if(person == null){
            saveOrUpdate(req);
        }else {
            person.setFirst_name(fname);
            person.setLast_name(lname);
            person.setMiddle_name(mname);
            person.setPosition(position);
            Contact contact = new Contact();
            contact.setNumber(number);
            contact.setPerson(person);
            contact.setContactType(contactTypeService.findTypeByName(type));
            person.getContacts().add(contact);
            personDao.update(person);
        }
    }

    public void deletePerson(Person person) {
        personDao.delete(person);
    }

    public void deleteById(Long id) {
        Person person = personDao.findById(id);
        deletePerson(person);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

}
