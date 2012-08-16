/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.Estate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author QuangVinh
 */
@Stateless
public class EstateFacade extends AbstractFacade<Estate> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstateFacade() {
        super(Estate.class);
    }
 
    @Override
    public void create(Estate estate) {
        em.persist(estate);
    }

    @Override
    public void edit(Estate estate) {
        em.merge(estate);
    }

    @Override
    public void remove(Estate estate) {
        em.remove(em.merge(estate));
    }  
    
    public Estate getEstateID(String estateID) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateID");
            q.setParameter("estateID", estateID);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }
    
     public Estate getEstateTitle(String estateTitle) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateTitle");
            q.setParameter("estateTitle", estateTitle);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }
     
     public Estate getEstateStartDay(String estateStartDay) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateStartDay");
            q.setParameter("estateStartDay", estateStartDay);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }
     
     public Estate getEstateEndDay(String estateEndDay) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateEndDay");
            q.setParameter("estateEndDay", estateEndDay);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }
     
    public Estate getEstateAddress(String estateAddress) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateStartDay");
            q.setParameter("estateAddress", estateAddress);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getEstateContent(String estateContent) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateContent");
            q.setParameter("estateContent", estateContent);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getEstateArea(String estateArea) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateArea");
            q.setParameter("estateArea", estateArea);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getEstateValue(String estateValue) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateValue");
            q.setParameter("estateValue", estateValue);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getEstateDriveway(String estateDriveway) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateDriveway");
            q.setParameter("estateDriveway", estateDriveway);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getEstateDirection(String estateDirection) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateDirection");
            q.setParameter("estateDirection", estateDirection);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    
    public Estate getEstateNumberOfRooms(String estateNumberOfRooms) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateNumberOfRooms");
            q.setParameter("estateNumberOfRooms", estateNumberOfRooms);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    
    public Estate getEstateNumberOfFloors(String estateNumberOfFloors) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateNumberOfFloors");
            q.setParameter("estateNumberOfFloors", estateNumberOfFloors);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
     
    public Estate getEstateNumberOfToilets(String estateNumberOfToilets) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateNumberOfToilets");
            q.setParameter("estateNumberOfToilets", estateNumberOfToilets);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getEstateNumOfView(String estateNumOfView) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByEstateNumOfView");
            q.setParameter("estateNumOfView", estateNumOfView);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
     
    public Estate getIsEnabled(String isEnabled) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByIsEnabled");
            q.setParameter("isEnabled", isEnabled);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getIsPaid(String isPaid) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findByIsPaid");
            q.setParameter("isPaid", isPaid);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    public Estate getSumValue(String sumValue) {
        Estate estate = null;
        try{
            Query q = em.createNamedQuery("Estate.findBySumValue");
            q.setParameter("sumValue", sumValue);
            estate = (Estate) q.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    } 
    
    
    
    
}
