/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Member1;
import com.mysweethome.entity.TypeOfMember;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class Member1Facade extends AbstractFacade<Member1> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(Member1 member) {
        em.persist(member);
    }

    @Override
    public void edit(Member1 member) {
        em.merge(member);
    }

    @Override
    public void remove(Member1 member) {
        em.remove(em.merge(member));
    }  

    public Member1Facade() {
        super(Member1.class);
    }
        
    public Member1 getUserName(String username) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByUserName");
            query.setParameter("userName", username);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public Member1 getPassWord(String pass) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByPassword");
            query.setParameter("password", pass);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getEmail(String email) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByEmail");
            query.setParameter("email", email);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getFullName(String fullName) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByFullName");
            query.setParameter("fullName", fullName);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    
    public Member1 getDateOfBirth(String dateOfBirth) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByDateOfBirth");
            query.setParameter("dateOfBirth", dateOfBirth);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    
    public Member1 getGender(String gender) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByGender");
            query.setParameter("gender", gender);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getAddress(String address) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByAddress");
            query.setParameter("address", address);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getTelephone(String telephone) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByTelephone");
            query.setParameter("telephone", telephone);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getCompany(String company) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByCompany");
            query.setParameter("company", company);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getIsEnabled(String isEnabled) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByIsEnabled");
            query.setParameter("isEnabled", isEnabled);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getCode(String code) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByCode");
            query.setParameter("code", code);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    
    public Member1 getImageUrl(String imageUrl) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByImageUrl");
            query.setParameter("imageUrl", imageUrl);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public Member1 getRole(String role) {
        Member1 user = null;
        try {
            Query query = em.createNamedQuery("Member1.findByRole");
            query.setParameter("role", role);
            user = (Member1) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public List<Member1> getAll()
    {
        List<Member1> users = null;
        try {
            Query query = em.createNamedQuery("Member1.findAll");
            users=query.getResultList();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
    public TypeOfMember getTypeOfMemberFromID(String id){
        TypeOfMember type = null;
        try {
            Query query = em.createNamedQuery("TypeOfMember.findByTypeOfMemberID");
            query.setParameter("typeOfMemberID", id);
            type=(TypeOfMember) query.getSingleResult();
        } catch (NoResultException ex) {
        }
        return type;
    }
    public int getLastRecordID(){
        Query q = em.createNamedQuery("Member1.findAll");
        List<Member1> memlist= q.getResultList();
                
        int i=memlist.size();
        i=i-1;
        
        int j=Integer.parseInt(memlist.get(i).getUserName());
        return j;
    }
    
    public List<Member1> getSellerList(){
        List<Member1> sellerList=new ArrayList<Member1>();
        try {
            Query query = em.createNamedQuery("Member1.findByTypeOfMemberID");
            query.setParameter("typeOfMemberID", "1");
            sellerList=query.getResultList();
        } catch (NoResultException ex) {
        }
        return sellerList;
    }
    
    public List<Member1> getBuyerList(){
        List<Member1> buyerList=new ArrayList<Member1>();
        try {
            Query query = em.createNamedQuery("Member1.findByTypeOfMemberID");
            query.setParameter("typeOfMemberID", "2");
            buyerList=query.getResultList();
        } catch (NoResultException ex) {
        }
        return buyerList;
    }
}
