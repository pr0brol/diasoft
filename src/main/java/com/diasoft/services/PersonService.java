package com.diasoft.services;


import com.diasoft.DAO.PersonDao;
import com.diasoft.entities.Person;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PersonService {

    private PersonDao personDao = new PersonDao();

    public Person findById(Long id) {
        return personDao.findById(id);
    }

    public void savePerson(Person person){
        personDao.save(person);
    }

    public void deletePerson(Person person){
        personDao.delete(person);
    }

    public void deleteById(Long id){
        Person person = personDao.findById(id);
        deletePerson(person);
    }

    public void updatePerson(Person person){
        personDao.update(person);
    }

    public List<Person> findAll(){
        return personDao.findAll();
    }


}
