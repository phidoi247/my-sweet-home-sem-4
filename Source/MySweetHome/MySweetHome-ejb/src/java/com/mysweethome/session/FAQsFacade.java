/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.FAQs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class FAQsFacade extends AbstractFacade<FAQs> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FAQsFacade() {
        super(FAQs.class);
    }
    
    @Override
    public void create(FAQs faq) {
        em.persist(faq);
    }

    @Override
    public void edit(FAQs faq) {
        em.merge(faq);
    }

    @Override
    public void remove(FAQs faq) {
        em.remove(em.merge(faq));
    }
    
    

    public FAQs getFAQsID(String faqsID) {
        FAQs fa=null;
        try{
        Query query=em.createNamedQuery("FAQs.findByFAQsID");
        query.setParameter("fAQsID", faqsID);
        fa=(FAQs) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return fa;

    }
     public FAQs getAnswer(String faqsAnswer) {
        FAQs fa=null;
        try{
        Query query=em.createNamedQuery("FAQs.findByAnswer");
        query.setParameter("answer", faqsAnswer);
        fa=(FAQs) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return fa;

    }
      public FAQs getQuestion(String faqsQuestion) {
        FAQs fa=null;
        try{
        Query query=em.createNamedQuery("FAQs.findByQuestion");
        query.setParameter("question", faqsQuestion);
        fa=(FAQs) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return fa;

    }
      public int getLastRecordID(){
          Query query=em.createNamedQuery("FAQs.findAll");
          List<FAQs> faqsList= query.getResultList();
          
            int i=faqsList.size();
            i=i-1;
        
            int j=Integer.parseInt(faqsList.get(i).getFAQsID());
        return j;
      }

}
