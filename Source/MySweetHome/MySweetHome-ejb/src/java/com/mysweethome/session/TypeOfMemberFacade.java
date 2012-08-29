/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.TypeOfMember;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class TypeOfMemberFacade extends AbstractFacade<TypeOfMember> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public TypeOfMemberFacade() {
        super(TypeOfMember.class);
    }
    
    @Override
    public void create(TypeOfMember typeofmember) {
        em.persist(typeofmember);
    }

    @Override
    public void edit(TypeOfMember typeofmember) {
        em.merge(typeofmember);
    }

    @Override
    public void remove(TypeOfMember typeofmember) {
        em.remove(em.merge(typeofmember));
    }  
    
    public List<TypeOfMember> getAll(){
        List<TypeOfMember> users = null;
        try {
            Query query = em.createNamedQuery("TypeOfMember.findAll");
            users=query.getResultList();
        } catch (NoResultException ex) {
        }
        return users;
    }
    
    public TypeOfMember find(String id) {
        Query query = em.createNamedQuery("TypeOfMember.findByTypeOfMemberID");
        return (TypeOfMember) query.getSingleResult();
    }
}
