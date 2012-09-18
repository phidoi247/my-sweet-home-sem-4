/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.FAQs;
import com.mysweethome.helper.messages;
import com.mysweethome.session.FAQsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Garena
 */
@ManagedBean (name = "FAQsMBean")
@SessionScoped
public class FAQsMBean {
    @EJB
    private FAQsFacade faqsfacade;

    public FAQs getFaq() {
        return faq;
    }

    public void setFaq(FAQs faq) {
        this.faq = faq;
    }
    private FAQs faq, faqselect;

    public FAQs getFaqselect() {
        return faqselect;
    }

    public void setFaqselect(FAQs faqselect) {
        this.faqselect = faqselect;
    }

    List<FAQs> faqList= new ArrayList<FAQs>();
    List<FAQs> filteredfaqList= new ArrayList<FAQs>();

    public List<FAQs> getFilteredfaqList() {
        return filteredfaqList = faqList;
    }

    public void setFilteredfaqList(List<FAQs> filteredfaqList) {
        this.filteredfaqList = filteredfaqList;
    }

    public List<FAQs> getFaqList() {
        faqList= faqsfacade.findAll();
        return faqList;
    }

    public void setFaqList(List<FAQs> faqList) {
        this.faqList = faqList;
    }

    public FAQsFacade getFaqsfacade() {
        return faqsfacade;
    }

    public void setFaqsfacade(FAQsFacade faqsfacade) {
        this.faqsfacade = faqsfacade;
    }
    /**
     * Creates a new instance of FAQsMBean
     */
    
    public FAQsMBean() {
        faq=new FAQs();
        faqsfacade=new FAQsFacade();
    }
    public FAQsFacade getFAQsFacade(){
        return  faqsfacade;
    }

   
    public void editFAQ(FAQs faqtemp){    
        getFAQsFacade().edit(faqtemp);
        messages.taoTB(FacesMessage.SEVERITY_INFO, "Edit success", "Edit success");        
    }

    public void removeFAQ(){
        String str=getFaqselect().getFAQsID();
        getFaqselect().setFAQsID(str);
        getFAQsFacade().remove(getFaqselect());
        this.faqselect = new FAQs();
    }
 
    public void createFAQ(){
        try{
            FAQs newFaq = new FAQs();            
        
            int id= getFAQsFacade().getLastRecordID();
            newFaq.setFAQsID(String.valueOf(id+1));
            
            newFaq.setQuestion(faq.getQuestion());
            newFaq.setAnswer(faq.getAnswer());
            getFAQsFacade().create(newFaq);
            messages.taoTB(FacesMessage.SEVERITY_INFO, "Create success!", "Create success!");
        } catch(Exception e){
            e.printStackTrace();
        }
        this.faq = new FAQs();   
    }
    
}
