/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.helper.MailConfig;
import com.mysweethome.helper.messages;
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
    public String contactName;
    public String contactAddress;
    public String contactTelephone;
    public String name;
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContactDetailsMBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String email;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
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
    public void sendContact() {
        if (!email.isEmpty()) {
//      send mail to user to active account
            try {
                String from = "quanghuy9289@gmail.com";
                String to = "quanghuy090289@gmail.com";
                String subject = title;
                String body = "Dear admin,\n";
                body += "My name is " + name + ".\n ";
                body += "Email " + email + ".\n ";
                body += "I have some contact to offer for you!\n";
                body += content;
                body += "Thanks you!\n";
                MailConfig config = new MailConfig();
                Message message = config.createMessage(from, to, subject, body);
                if (config.sendEmail(message)) {
                    System.out.println("Done");
                } else {
                    System.out.println("Failed");
                }
            } catch (MessagingException ex) {
            }
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Send mail success", "Send mail success.");
        } else {
            messages.taoTB(FacesMessage.SEVERITY_ERROR, "Email is empty", "Email is empty");
        }

    }
}
