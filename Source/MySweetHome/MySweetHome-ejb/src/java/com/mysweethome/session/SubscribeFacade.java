/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Subscribe;
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
public class SubscribeFacade extends AbstractFacade<Subscribe> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;
   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubscribeFacade() {
        super(Subscribe.class);
    }
    
    @Override
    public void create(Subscribe subscribe) {
        em.persist(subscribe);
    }

    @Override
    public void edit(Subscribe subscribe) {
        em.merge(subscribe);
    }

    @Override
    public void remove(Subscribe subscribe) {
        em.remove(em.merge(subscribe));
    }  
    
    public Subscribe getSubscribeID(String subscribeID){
        Subscribe sub=null;
        try{
            Query query=em.createNamedQuery("Subscribe.findBySubscribeID");
            query.setParameter("subscribeID", subscribeID);
            sub=(Subscribe) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sub;
    }
    
    public Subscribe getSubscribeName(String subscribeName){
        Subscribe sub=null;
        try{
            Query query=em.createNamedQuery("Subscribe.findBySubscribeName");
            query.setParameter("subscribeName", subscribeName);
            sub=(Subscribe) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sub;
    }
    
    public Subscribe getFeePerDay(String feePerDay){
        Subscribe sub=null;
        try{
            Query query=em.createNamedQuery("Subscribe.findByFeePerDay");
            query.setParameter("feePerDay", feePerDay);
            sub=(Subscribe) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sub;
    }
    
    public int getLastRecordID(){
        Query q= em.createNamedQuery("Subscribe.findAll");
        List<Subscribe> sublist= q.getResultList();
                
        int i=sublist.size();
        i=i-1;
        
        int j=Integer.parseInt(sublist.get(i).getSubscribeID());
        return j;
    }
    
}
