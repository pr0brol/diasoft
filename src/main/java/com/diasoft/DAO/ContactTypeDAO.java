package com.diasoft.DAO;

import com.diasoft.entities.ContactType;
import com.diasoft.entities.Person;
import com.diasoft.utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ContactTypeDAO {

    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();

    public ContactType findTypeByName(String type){
        Session session = sf.openSession();
        Query queryObject = session.createQuery("from ContactType where type = :value");
        queryObject.setParameter("value", type);
        List<ContactType> list = queryObject.list();
        session.close();
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public void save(ContactType type){
        Session session = sf.openSession();
        Transaction ta = session.beginTransaction();
        session.saveOrUpdate(type);
        ta.commit();
        session.close();
    }


}
