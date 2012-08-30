/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.FAQs;
import com.mysweethome.session.FAQsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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

   
    public void editFAQs(){
        String str=faq.getFAQsID();
        FAQs fa=faqsfacade.getFAQsID(str);
        fa.setAnswer(faq.getAnswer());
        fa.setQuestion(faq.getQuestion());
               
        faqsfacade.edit(fa);
    }

    public void removeFAQs(){
        String str=faq.getFAQsID();
        faq.setFAQsID(str);
        faqsfacade.remove(faq);
    }
    public void removeFAQ(String faqID){
        FAQs faqtemp=this.getFAQsFacade().find(faqID);
         
        this.getFAQsFacade().remove(faq);
    }
    public String createFAQ(){
        FAQs faqtemp= new FAQs();
        
        String result="False";
        try{
        int id= getFAQsFacade().getLastRecordID();
        faqtemp.setFAQsID(String.valueOf(id+1));
        faqtemp.setQuestion(faqselect.getQuestion());      
        faqtemp.setAnswer(faqselect.getAnswer());
        
        getFAQsFacade().create(faqtemp);
        result="True";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;       
    }
    
}
