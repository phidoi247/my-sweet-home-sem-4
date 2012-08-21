/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.ContactDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LongVu
 */
@Stateless
public class ContactDetailsFacade extends AbstractFacade<ContactDetails> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactDetailsFacade() {
        super(ContactDetails.class);
    }
    
    @Override
    public void create(ContactDetails ctdetails) {
        em.persist(ctdetails);
    }

    @Override
    public void edit(ContactDetails ctdetails) {
        em.merge(ctdetails);
    }

    @Override
    public void remove(ContactDetails ctdetails) {
        em.remove(em.merge(ctdetails));
    }    
    
    
}
