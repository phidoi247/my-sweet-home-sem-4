/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.ContactDetails;
import com.mysweethome.session.ContactDetailsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LongVu
 */
@ManagedBean (name = "ContacDetailsMBean")
@SessionScoped
public class ContactDetailsMBean {

    /**
     * Creates a new instance of ContactDetailsMBean
     */
    
    @EJB
    ContactDetails contact;

    public ContactDetails getContact() {
        return contact;
    }

    public void setContact(ContactDetails contact) {
        this.contact = contact;
    }

    public ContactDetailsFacade getContactfacade() {
        return contactfacade;
    }

    public void setContactfacade(ContactDetailsFacade contactfacade) {
        this.contactfacade = contactfacade;
    }

    public List<ContactDetails> getListcontact() {
        return listcontact;
    }

    public void setListcontact(List<ContactDetails> listcontact) {
        this.listcontact = listcontact;
    }
    ContactDetailsFacade contactfacade;
    List<ContactDetails> listcontact= new ArrayList<ContactDetails>();
    
    public ContactDetailsMBean() {
    }
    
//    public String createContact(){
//        String result="False";
//        
//        ContactDetails contacttemp= new ContactDetails();
//        
//        contact
//        
//        return result;
//    }
}
