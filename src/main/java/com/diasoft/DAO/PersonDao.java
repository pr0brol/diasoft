package com.diasoft.DAO;

import com.diasoft.entities.Person;
import com.diasoft.utils.SessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDao {
    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();


    public Person findById(Long id){
        Session session = sf.openSession();
        Person person =  session.get(Person.class, id);
        session.close();
        return person;
    }

    public Person find(String firstName, String lastName){
        Session session = sf.openSession();
        String queryString = "from Person where first_name = :first and last_name = :last";
        Query queryObject = session.createQuery(queryString);
        queryObject.setParameter("first", firstName);
        queryObject.setParameter("last", lastName);
        List<Person> list = queryObject.list();
        session.close();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public void save(Person person){
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.saveOrUpdate(person);
        ta.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.update(person);
        ta.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.delete(person);
        ta.commit();
        session.close();
    }

    public List<Person> findAll() {
        Session session = sf.openSession();
        List<Person> persons = (List<Person>)  session.createQuery("From Person").list();
        session.close();
        return persons;
    }
}
