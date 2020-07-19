package com.diasoft.services;

import com.diasoft.DAO.PersonDao;
import com.diasoft.entities.Person;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class PersonServiceTest extends TestCase {

    PersonDao personDao = new PersonDao();
    String fname = "testFirst";
    String lName = "testLast";

    @Test
    public void testSaveOrUpdate() {

        Person person = new Person();

        person.setFirst_name(fname);
        person.setLast_name(lName);

        personDao.save(person);

        System.out.println(personDao.find(fname, lName).toString());

    }

    @Test
    public void testDeletePerson() {
        List<Person> allPerson = personDao.findAll();
        System.out.println(allPerson.size());
        Person person = personDao.find(fname, lName);
        personDao.delete(person);
        allPerson = personDao.findAll();
        System.out.println(allPerson.size());

    }

    @Test
    public void testFindAll() {
        List<Person> allPerson = personDao.findAll();
        for(Person p: allPerson){
            System.out.println(p.toString());
        }
    }
}