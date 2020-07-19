package com.diasoft.services;

import com.diasoft.DAO.ContactTypeDAO;
import com.diasoft.entities.ContactType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContactTypeService {
    private ContactTypeDAO contactTypeDAO = new ContactTypeDAO();

    public ContactType findTypeByName(String type){
        return contactTypeDAO.findTypeByName(type);
    }

    public void save(ContactType type){
        contactTypeDAO.save(type);
    }
}
