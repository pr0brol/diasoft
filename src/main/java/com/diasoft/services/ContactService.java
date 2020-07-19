package com.diasoft.services;

import com.diasoft.DAO.ContactDAO;
import com.diasoft.entities.Contact;
import com.diasoft.entities.ContactType;

public class ContactService {
    private ContactDAO contactDAO = new ContactDAO();

    public Contact findContactByNumber(String number){
        return contactDAO.findContactByNumber(number);
    }

    public void save(Contact contact){
        contactDAO.save(contact);
    }
}
