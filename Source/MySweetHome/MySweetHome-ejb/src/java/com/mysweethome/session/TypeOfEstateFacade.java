/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.TypeOfEstate;
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
public class TypeOfEstateFacade extends AbstractFacade<TypeOfEstate> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeOfEstateFacade() {
        super(TypeOfEstate.class);
    }
    
    @Override
    public void create(TypeOfEstate typeofestate) {
        em.persist(typeofestate);
    }

    @Override
    public void edit(TypeOfEstate typeofestate) {
        em.merge(typeofestate);
    }

    @Override
    public void remove(TypeOfEstate typeofestate) {
        em.remove(em.merge(typeofestate));
    }  
    
    public List<TypeOfEstate> getAllTypeOfEstate(){
        Query q= em.createNamedQuery("TypeOfEstate.findAll");
        return q.getResultList();
    }
}
