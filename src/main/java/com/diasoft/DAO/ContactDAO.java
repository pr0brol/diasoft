package com.diasoft.DAO;

import com.diasoft.entities.Contact;
import com.diasoft.entities.ContactType;
import com.diasoft.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class ContactDAO {

    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();

    public Contact findContactByNumber(String number){
        Session session = sf.openSession();
        Query queryObject = session.createQuery("from Contact where number = :value");
        queryObject.setParameter("value", number);
        List<Contact> list = queryObject.list();
        session.close();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public void save(Contact contact){
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.saveOrUpdate(contact);
        ta.commit();
        session.close();
    }


}
