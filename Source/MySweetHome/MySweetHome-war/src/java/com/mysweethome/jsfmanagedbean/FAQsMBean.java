/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.jsfmanagedbean;

import com.mysweethome.entity.FAQs;
import com.mysweethome.session.FAQsFacade;
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
    private FAQs faq;

    /**
     * Creates a new instance of FAQsMBean
     */
    
    public FAQsMBean() {
        faq=new FAQs();
        faqsfacade=new FAQsFacade();
    }

    public void createFAQs(){
        faq.getFAQsID();
        faq.getAnswer();
        faq.getQuestion();

        faqsfacade.create(faq);
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
}
