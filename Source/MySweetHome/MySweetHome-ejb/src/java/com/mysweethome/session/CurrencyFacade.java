/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Currency;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class CurrencyFacade extends AbstractFacade<Currency> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Currency getCurrencyID(String currencyID){
        Currency currency=null;
        try{
            Query query=em.createNamedQuery("Currency.findByCurrencyID");
            query.setParameter("currencyID", currencyID);
            currency=(Currency) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return currency;
    }
    
    public Currency getCurrencyName(String currencyName){
        Currency currency=null;
        try{
            Query query=em.createNamedQuery("Currency.findByCurrencyName");
            query.setParameter("currencyName", currencyName);
            currency=(Currency) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return currency;
    }
    
    public Currency getCurrencyRate(String vndRate){
        Currency currency=null;
        try{
            Query query=em.createNamedQuery("Currency.findByVNDRate");
            query.setParameter("vndRate", vndRate);
            currency=(Currency) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return currency;
    }
    
    
    public CurrencyFacade() {
        super(Currency.class);
    }
    
    @Override
    public void create(Currency currency) {
        em.persist(currency);
    }

    @Override
    public void edit(Currency currency) {
        em.merge(currency);
    }

    @Override
    public void remove(Currency currency) {
        em.remove(em.merge(currency));
    }  
}
