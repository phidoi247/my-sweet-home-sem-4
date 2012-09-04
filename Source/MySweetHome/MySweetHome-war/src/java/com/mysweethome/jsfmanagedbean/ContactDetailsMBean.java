/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.ContactDetails;
import com.mysweethome.helper.MailConfig;
import com.mysweethome.helper.messages;
import com.mysweethome.session.ContactDetailsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 *
 * @author LongVu
 */
@ManagedBean(name = "ContacDetailsMBean")
@SessionScoped
public class ContactDetailsMBean {

    /**
     * Creates a new instance of ContactDetailsMBean
     */
    @EJB
    ContactDetails contact;
    ContactDetails newContact;
    public String contactName;
    public String contactAddress;
    public String contactTelephone;
    public String contactEmail;
    public String messagesTB;
    public messages msg;

    public String getMessagesTB() {
        return messagesTB;
    }

    public void setMessages(String messagesTB) {
        this.messagesTB = messagesTB;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public ContactDetails getNewContact() {
        newContact = contactfacade.find("Contact01");
        return newContact;
    }

    public void setNewContact(ContactDetails newContact) {
        this.newContact = newContact;
    }

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

        return listcontact = contactfacade.findAll();
    }

    public void setListcontact(List<ContactDetails> listcontact) {
        this.listcontact = listcontact;
    }
    ContactDetailsFacade contactfacade;
    List<ContactDetails> listcontact = new ArrayList<ContactDetails>();

    public ContactDetailsMBean() {
        contact = new ContactDetails();
        contactfacade = new ContactDetailsFacade();
    }

    public void sendEmail() {

        contact.setContactName(contactName);
        contact.setContactAddress(contactAddress);
        contact.setContactEmail(contactEmail);
        contact.setContactTelephone(contactTelephone);
        //String code = new RandomCode().createRandomString();

        //send mail to user to active account
        try {
            String from = "quanghuy9289@gmail.com";
            String to = contactEmail;
            String subject = "My Sweet Home";
            String body = "Dear " + contactName + ",\n";
            body += "Wellcome to my website!\n";
            body += "You had registed a new account. Please active this account by clicking below link:\n";
            // body += "http://localhost:8080/MySweetHome-war/activeAccount.jsf?username=" + contactName + "&code=" + code + "\n";
            body += "Thanks you!\n";
            body += "--------------------------\n";
            body += "My group:\n";
            body += "Ngo Quang Huy\n";
            body += "Vu Long\n";
            body += "Nguyen Anh Tan\n";
            body += "Huynh Quang Vinh\n";
            body += "Le Xuan Trung";
            MailConfig config = new MailConfig();
            Message message = config.createMessage(from, to, subject, body);
            config.sendEmail(message);
        } catch (MessagingException ex) {
        }

        messages.taoTB(FacesMessage.SEVERITY_INFO, "Register success", "Registration success. Please check your email to active account before login to system.");
    }
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

